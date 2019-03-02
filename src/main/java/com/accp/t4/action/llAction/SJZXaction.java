package com.accp.t4.action.llAction;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.accp.t4.biz.llBiz.GRZXBiz;
import com.accp.t4.biz.llBiz.OrderBiz;
import com.accp.t4.biz.llBiz.RefundBiz;
import com.accp.t4.biz.llBiz.SJZXBiz;
import com.accp.t4.biz.llBiz.UserBiz;
import com.accp.t4.entity.llEntity.Appraisalapply;
import com.accp.t4.entity.llEntity.Goldnotes;
import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Refund;
import com.accp.t4.entity.llEntity.User;
import com.accp.t4.util.file.Upload;
import com.accp.t4.vo.llVO.RefundVO;
import com.accp.t4.vo.llVO.UserVo;

@Controller
@RequestMapping("/sjzx/")
public class SJZXaction {
	@Autowired
	private UserBiz userBiz;
	@Autowired
	private SJZXBiz sjzxBiz;
	@Autowired
	private GRZXBiz grzxBiz;
	@Autowired
	private RefundBiz refundBiz;
	@Autowired
	private OrderBiz orderBiz; 
	

	/**
	 * 商家中心
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("index")
	public String selectUser(Model model, HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		if (userVo.getMerchanttype() == 0) {
			return "qianTai/NewFile"; // 未入驻
		} else {
			model.addAttribute("user", userBiz.selectUser(userVo.getUserid()));
			return "qianTai/sjzx-index";
		}
	}

	/**
	 * 查询发布的服务
	 * 
	 * @param num
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("sjzx-services")
	public String getServices(Integer num, Model model, HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		model.addAttribute("PAGE_INFO", sjzxBiz.selectServices(userVo.getUserid(), num));
		return "qianTai/sjzx-services";
	}

	/**
	 * 收到的预订
	 * 
	 * @param session
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("sjzx-order")
	public String queryYuDing(HttpSession session, Model model, Integer num) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		model.addAttribute("pageInfo", grzxBiz.selectOrder(num, null, null, userVo.getUserid()));
		return "qianTai/sjzx-order";
	}

	/**
	 * 收到预订订单详情
	 * 
	 * @param model
	 * @param orderId
	 * @return
	 */
	@GetMapping("sjrz-order-deatil")
	public String orderDetail(Model model, String orderId) {
		model.addAttribute("order", grzxBiz.getOrder(orderId));
		return "qianTai/sjrz-order-deatil";
	}

	/**
	 * 修改订单状态信息(接单、取消订单、提供服务...)
	 * 
	 * @return
	 */
	@GetMapping("updateOrder")
	public String updateOrder(String orderId, Integer orderStatus, Model model) {
		Orders order = new Orders();
		order.setOrderid(orderId);
		order.setOrderstatus(orderStatus);
		sjzxBiz.udpateOrder(order);
		return "redirect:/sjzx/sjzx-order?num=1";
	}
	/**
	 * 查询我的申请鉴定
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("sjzx-auth")
	public String getApply(HttpSession session, Model model) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		User user = userBiz.selectUser(userVo.getUserid());
		model.addAttribute("LIST",
				sjzxBiz.getApply(userVo.getUserid(), user.getFirstserviceid(), user.getSecondserviceid()));
		return "qianTai/sjzx-auth";
	}
	/**
	 * 添加申请鉴定
	 * @param apply
	 * @param session
	 * @param schoolReport
	 * @param transLate
	 * @param koreaLicense
	 * @param hospitalLicense
	 * @return
	 */
	@PostMapping("addApply")
	public String addAppraisaApply(Appraisalapply apply, HttpSession session, MultipartFile schoolReport,
			MultipartFile transLate,MultipartFile koreaLicense,MultipartFile hospitalLicense) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		apply.setUserid(userVo.getUserid());
		try {
			if (schoolReport!=null) {
				String filesc = Upload.uploadFile(schoolReport);
				apply.setSchoolreport(filesc);
			}
			System.out.println(transLate);
			if(transLate!=null) {
				String translatesc = Upload.uploadFile(transLate);
				apply.setTranslate(translatesc);
			}
			if(koreaLicense!=null) {
				String koreaLicensesc = Upload.uploadFile(koreaLicense);
				apply.setKorealicense(koreaLicensesc);
			}
			if(hospitalLicense!=null) {
				String hospitalLicensesc = Upload.uploadFile(hospitalLicense);
				apply.setKorealicense(hospitalLicensesc);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		apply.setSubmittime(new Date());
		apply.setAuditstatus(1);
		sjzxBiz.addAppraisaApply(apply);
		return "redirect:/sjzx/sjzx-auth";
	}
	
	@GetMapping("sjzx-refund")
	public String selectRefunds(Integer num,HttpSession session,Model model) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		model.addAttribute("pageInfo", refundBiz.selectRefunds(num, null, userVo.getUserid()));
		return "qianTai/sjzx-refund";
	}
	
	@GetMapping("sjzx-refund-detail")
	public String selectRefundDetail(Integer refundId,Model model) {
		model.addAttribute("refund", refundBiz.selectRefundDetail(refundId));
		return "qianTai/sjzx-refund-detail";
	}
	@GetMapping("refundOk")
	public String refundOK(Integer refundId,HttpSession session) {
		UserVo userVo = (UserVo) session.getAttribute("user");
		RefundVO refundVo=refundBiz.selectRefundDetail(refundId);
		System.out.println(refundVo);
		System.out.println(refundVo.getUserid()+"..."+refundVo.getOrderid()+"..."+refundVo.getRefundid());
		System.out.println(refundVo.getOrders());
		System.out.println(refundVo.getUser());
		System.out.println(userVo);
		Refund refund = new Refund();
		refund.setRefundid(refundId);
		refund.setActualrefundmoney(refundVo.getApplyrefundmoney());
		refund.setAudittime(new Date());
		refund.setBusinessremarks("同意退款");
		refundBiz.updateRefund(refund);
		
		Orders order = new Orders();
		order.setOrderid(refundVo.getOrderid());
		order.setRefundstatus(5);
		orderBiz.updateOrderDetail(order);
		//商家减金币
		Goldnotes goldnotes1=new Goldnotes(userVo.getUserid(), 7, "订单退款："+refundVo.getOrderid(),-refundVo.getApplyrefundmoney(), 2);
		System.out.println(goldnotes1);
		orderBiz.addGoldnotes(goldnotes1);
		orderBiz.updateUserMoney(-refundVo.getApplyrefundmoney(), userVo.getUserid());
		//用户增金币
		Goldnotes goldnotes2=new Goldnotes(refundVo.getUserid(), 7, "订单退款："+refundVo.getOrders().getOrderid(),refundVo.getApplyrefundmoney(), 2);
		orderBiz.addGoldnotes(goldnotes2);
		orderBiz.updateUserMoney(refundVo.getApplyrefundmoney(), refundVo.getUserid());
		return "redirect:/sjzx/sjzx-refund?num=1";
	}
	@GetMapping("sjzx-refund-why")
	public String refundWhy(Integer refundId,Model model) {
		model.addAttribute("refund", refundBiz.selectRefundDetail(refundId));
		return "qianTai/sjzx-refund-why";
	}
	/**
	 * 不同意退款
	 * @return
	 */
	@PostMapping("noRefund")
	public String noRefund(Refund refund) {
		refund.setAudittime(new Date());
		refundBiz.updateRefund(refund);
		Orders order= new Orders();
		order.setOrderid(refund.getOrderid());
		order.setRefundstatus(2);
		orderBiz.updateOrderDetail(order);
		return "redirect:/sjzx/sjzx-refund?num=1";
	}
	
}
