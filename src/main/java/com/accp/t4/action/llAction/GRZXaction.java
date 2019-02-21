package com.accp.t4.action.llAction;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.t4.biz.llBiz.GRZXBiz;
import com.accp.t4.vo.llVO.OrderVO;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/grzx/")
public class GRZXaction {
	@Autowired
	private GRZXBiz biz;
	
	@GetMapping("user")
	public String selectUser(Model model,HttpSession session) {
		//model.addAttribute("user", biz.selectUser(24));
		session.setAttribute("user", biz.selectUser(24));
		model.addAttribute("yuDing", biz.selectOrder(1, 24,"1",null));//最新预订
		return "qianTai/grzx-index";
	}
	/**
	 * 预订的服务及查询详情
	 * @param model
	 * @param orderId
	 * @return
	 */
	@GetMapping("order")
	public String selectOrder(Model model,String orderId) {
		PageInfo<OrderVO> orderPage= biz.selectOrder(1, 24,null,orderId);
		if(orderId==null) {
			model.addAttribute("orderPage", orderPage);
			return "qianTai/grzx-order";    //我预订的服务
		}else {
			OrderVO order = orderPage.getList().get(0);
			model.addAttribute("order", order);
			return "qianTai/grzx-order-detail";   //预订详情
		}
	}
	/**
	 * 我的金币
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("money")
	public String selectMoney(Model model,Integer num) {
		model.addAttribute("moneyPage",biz.selectMoney(num, 24));
		return "qianTai/grzx-moneys";
	}
	/**
	 * 我的积分
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("jiFen")
	public String selectJiFen(Model model,Integer num) {
		model.addAttribute("JiFenPage",biz.selectJiFen(num, 24));
		return "qianTai/grzx-points";
	}
	/**
	 * 我的退款
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("refunds")
	public String selectRefunds(Model model,Integer num) {
		model.addAttribute("RefundPage",biz.selectRefund(num, 24));
		return "qianTai/grzx-refund";
	}
	/**
	 * 我的评价
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("Evaluation")
	public String selectEvaluation(Model model,Integer num) {
		model.addAttribute("PingJiaPage",biz.selectEvaluation(num, 25));
		return "qianTai/grzx-comments";
	}
	/**
	 * 收藏的服务
	 * @param model
	 * @param num
	 * @return
	 */
	@GetMapping("serviceCollection")
	public String ServiceCollection(Model model,Integer num) {
		model.addAttribute("fuWuCollectionPage", biz.selectServiceCollection(num, 24));
		return "qianTai/grzx-favs";
	}
}
