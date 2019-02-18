package com.accp.t4.action.llAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.t4.biz.llBiz.GRZXBiz;

@Controller
@RequestMapping("/grzx/")
public class GRZXaction {
	@Autowired
	private GRZXBiz biz;
	
	@GetMapping("user")
	public String selectUser(Model model) {
		model.addAttribute("user", biz.selectUser(24));
		return "qianTai/grzx-index";
	}
	
	@GetMapping("order")
	public String selectOrder(Model model) {
		model.addAttribute("orderPage", biz.selectOrder(1, 24));
		return "qianTai/grzx-order";
	}
	
	@GetMapping("money")
	public String selectMoney(Model model,Integer num) {
		model.addAttribute("moneyPage",biz.selectMoney(1, 24));
		return "qianTai/grzx-moneys";
	}
	
	@GetMapping("jiFen")
	public String selectJiFen(Model model,Integer num) {
		model.addAttribute("JiFenPage",biz.selectJiFen(num, 24));
		return "qianTai/grzx-points";
	}
	@GetMapping("refunds")
	public String selectRefunds(Model model,Integer num) {
		model.addAttribute("RefundPage",biz.selectRefund(num, 24));
		return "qianTai/grzx-refund";
	}
	@GetMapping("Evaluation")
	public String selectEvaluation(Model model,Integer num) {
		model.addAttribute("PingJiaPage",biz.selectEvaluation(num, 25));
		return "qianTai/grzx-comments";
	}
}
