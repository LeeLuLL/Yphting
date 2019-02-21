package com.accp.t4.action.wxxAction;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/")
public class ViewServlet {
	//修改密码
	@GetMapping("updPwd")
	public String goToUpdate() {
		return "qianTai/zhsz-xgmm";
	}
	
	//商家入驻
	@GetMapping("sjrz")
	public String goToRuZhu() {
		return "qianTai/sjrz-xz";
	}
	
	//商家入驻-填写资料
	@GetMapping("sjrz-txzl")
	public String goToRuZhuTianXie() {
		return "qianTai/sjrz-txzl";
	}
	
	//商家资料-审核资料
	@GetMapping("sjrz-shzl")
	public String goToShengHe() {
		return "qianTai/sjrz-shzl";
	}
	
	//商家资料-开店成功
	@GetMapping("sjrz-kdcg")
	public String goToChengGong() {
		return "qianTai/sjrz-yktsj";
	}
	
	//个人中心首页
	@GetMapping("grzx-index")
	public String goToGeRen() {
		return "qianTai/grzx-index";
	}
	
	//首页
	@GetMapping("fw-sy")
	public String goToIndex(HttpSession session) {
		return "qianTai/fw-sy";
	}
}
