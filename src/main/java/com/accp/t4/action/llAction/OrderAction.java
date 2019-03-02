package com.accp.t4.action.llAction;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.accp.t4.biz.llBiz.GRZXBiz;
import com.accp.t4.biz.llBiz.OrderBiz;
import com.accp.t4.entity.llEntity.Evaluationservice;
import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Refund;
import com.accp.t4.util.file.Upload;
import com.accp.t4.vo.llVO.OrderVO;
import com.accp.t4.vo.llVO.UserVo;

@Controller
@RequestMapping("/ll/c/")
public class OrderAction {
	@Autowired
	private OrderBiz orderBiz;
	@Autowired
	private GRZXBiz grzxBiz;
	
	@GetMapping("order/pay")
	public String payMoney(String orderId,Model model,HttpSession session) {
		UserVo user =(UserVo)session.getAttribute("user");
		OrderVO orderVo=grzxBiz.getOrder(orderId);
		Orders order = new Orders();
		order.setOrderid(orderId);
		order.setOrderstatus(2);
		order.setPaymenttime(new Date());
		orderBiz.updateOrder(orderVo.getSmallPlan(), user.getUserid(), order);
		return "redirect:/grzx/orders";
	}
	/**
	 * 取消服务
	 * @param orderId
	 * @return
	 */
	@GetMapping("cancelOrder")
	public String cancelOrder(String orderId) {
		Orders order = new Orders();
		order.setOrderid(orderId);
		order.setOrderstatus(6);
		orderBiz.cancelOrder(order);
		return "redirect:/grzx/orders";
	}
	/**
	 * 确认订单完成
	 * @param orderId
	 * @return
	 */
	@GetMapping("orderOK")
	public String orderOK(String orderId) {
		OrderVO orderVo=grzxBiz.getOrder(orderId);
		Orders order=new Orders();
		order.setOrderid(orderId);
		order.setOrderstatus(5);
		order.setCommentstatus(1);
		order.setRefundstatus(0);
		orderBiz.orderOk(orderVo.getSmallPlan(), orderVo.getMerchantID(), order);
		return "redirect:/grzx/orders";
	}
	/**
	 * 去评价
	 * @param orderId
	 * @param model
	 * @return
	 */
	@GetMapping("toEvaluate")
	public String toEvaluate(String orderId,Model model) {
		model.addAttribute("order", grzxBiz.getOrder(orderId));
		return "qianTai/grzx-order-evaluate";
	}
	/**
	 * 确认评价
	 * @param evaluate
	 * @param orderid
	 * @param session
	 * @return
	 */
	@RequestMapping("evaluateOK")
	public String evaluateOK(Evaluationservice evaluate, String orderId, HttpSession session) {
		// 新增评价信息，修改订单评价状态
		Integer userId = ((UserVo) session.getAttribute("user")).getUserid();
		OrderVO orderVo=grzxBiz.getOrder(orderId);
		System.out.println(orderVo);
		evaluate.setServiceid(orderVo.getServiceID());
		evaluate.setUserid(userId);
		evaluate.setServiceappraisedate(new Date());
		Orders order =new Orders();
		order.setOrderid(orderId);
		order.setCommentstatus(2);
		orderBiz.evaluateOK(evaluate, order);
		return "redirect:/grzx/Evaluation?num=1";
	}
	
	/**
	 * 确认申请退款
	 * @param refund
	 * @param file
	 * @param model
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("refundOK")
	public String refundOK(Refund refund,MultipartFile file,Model model,HttpSession session) throws IllegalStateException, IOException {
		// 新增退款信息，修改订单退款状态
		Integer userId = ((UserVo) session.getAttribute("user")).getUserid();
		refund.setPoint(1);
		refund.setUserid(userId);
		refund.setApplicationtime(new Date());
		if (file != null && !file.isEmpty()) {
			String fileName = Upload.uploadFile(file);
			refund.setRefundimg(fileName);
		}
		refund.setAuditstatus(1);
		Orders order = new Orders();
		order.setOrderid(refund.getOrderid());
		order.setRefundstatus(1);
		orderBiz.refundOK(refund, order);
		return "redirect:/grzx/orders";
	}
	/**
	 * 申请退款
	 * @param orderId
	 * @param model
	 * @return
	 */
	@RequestMapping("toRefund")
	public String toRefund(String orderId,Model model) {
		model.addAttribute("order", grzxBiz.getOrder(orderId));
		return "qianTai/grzx-order-refund";
	}
	
}
