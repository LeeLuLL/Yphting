package com.accp.t4.action.llAction;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.t4.biz.llBiz.GRZXBiz;
import com.accp.t4.biz.llBiz.OrderBiz;
import com.accp.t4.biz.llBiz.RefundBiz;
import com.accp.t4.biz.llBiz.UserBiz;
import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Refund;
import com.accp.t4.vo.llVO.OrderVO;
import com.accp.t4.vo.llVO.UserVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/grzx/")
public class GRZXaction {
	@Autowired
	private GRZXBiz biz;
	
	@Autowired
	private UserBiz userBiz;
	
	@Autowired
	private RefundBiz refundBiz;
	
	@Autowired
	private OrderBiz orderBiz;
	
	@GetMapping("index")
	public String selectUser(Model model,HttpSession session,Integer userId) {
		//model.addAttribute("user", biz.selectUser(24));
		if(userId==null)
			userId=24;
		session.setAttribute("user", userBiz.selectUser(userId));
		model.addAttribute("yuDing", biz.selectOrder(1, userId,"1",null));//最新预订
		return "qianTai/grzx-index";
	}
	/**
	 * 预订的服务及查询详情
	 * @param model
	 * @param orderId
	 * @return
	 */
	@GetMapping("orders")
	public String selectOrders(Model model,HttpSession session) {
		UserVo userVo=(UserVo)session.getAttribute("user");
		PageInfo<OrderVO> orderPage= biz.selectOrder(1, userVo.getUserid(),null,null);
		model.addAttribute("orderPage", orderPage);
		return "qianTai/grzx-order";    //我预订的服务
	}
	@GetMapping("orderDetail")
	public String getOrder(Model model,String orderId) {
		model.addAttribute("order", biz.getOrder(orderId));
		return "qianTai/grzx-order-detail";
	}
	/**
	 * 我的金币
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("money")
	public String selectMoney(Model model,Integer num,HttpSession session) {
		UserVo userVo=(UserVo)session.getAttribute("user");
		model.addAttribute("moneyPage",biz.selectMoney(num, userVo.getUserid()));
		return "qianTai/grzx-moneys";
	}
	/**
	 * 我的积分
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("jiFen")
	public String selectJiFen(Model model,Integer num,HttpSession session) {
		UserVo userVo=(UserVo)session.getAttribute("user");
		model.addAttribute("JiFenPage",biz.selectJiFen(num, userVo.getUserid()));
		return "qianTai/grzx-points";
	}
	/**
	 * 我的退款
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("refunds")
	public String selectRefunds(Model model,Integer num,HttpSession session) {
		UserVo userVo=(UserVo)session.getAttribute("user");
		model.addAttribute("RefundPage", refundBiz.selectRefunds(num, userVo.getUserid(), null));
		/*model.addAttribute("RefundPage",biz.selectRefund(num, userVo.getUserid()));*/
		return "qianTai/grzx-refund";
	}
	/**
	 * 退款详情
	 * @param model
	 * @param refundId
	 * @return
	 */
	@GetMapping("refundDetail")
	public String refundDetail(Model model,Integer refundId) {
		model.addAttribute("refund", refundBiz.selectRefundDetail(refundId));
		return "qianTai/grzx-refund-detail";
	}
	/**
	 * 我的评价
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("Evaluation")
	public String selectEvaluation(Model model,Integer num,HttpSession session) {
		Integer userId=((UserVo)session.getAttribute("user")).getUserid();
		model.addAttribute("PingJiaPage",biz.selectEvaluation(num,userId));
		return "qianTai/grzx-comments";
	}
	/**
	 * 收藏的服务
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("serviceCollection")
	public String ServiceCollection(Model model,Integer num,HttpSession session) {
		UserVo userVo=(UserVo)session.getAttribute("user");
		model.addAttribute("fuWuCollectionPage", biz.selectServiceCollection(num,userVo.getUserid()));
		return "qianTai/grzx-favs";
	}
	/**
	 * 支付金币
	 * @return
	 */
	@GetMapping("grzx-order-pay")
	public String toPay(Model model,String orderId) {
		model.addAttribute("order", biz.getOrder(orderId));
		return "qianTai/grzx-order-pay";
	}
	
	@GetMapping("applyAdmin")
	public String applyAdmin(Integer refundId,String orderId) {
		Refund refund = new Refund();
		refund.setRefundid(refundId);
		refund.setPoint(2);
		refundBiz.updateRefund(refund);
		Orders order = new Orders();
		order.setOrderid(orderId);
		order.setRefundstatus(3);
		orderBiz.updateOrderDetail(order);
		return "redirect:/grzx/refunds?num=1";
	}
	
}
