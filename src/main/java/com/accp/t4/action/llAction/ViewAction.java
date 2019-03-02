package com.accp.t4.action.llAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/")
public class ViewAction {
	/**
	 * 去入驻
	 * 
	 * @return
	 */
	@GetMapping("sjrz-xz")
	public String toRuZhu() {
		return "qianTai/sjrz-xz";
	}

	/**
	 * 填写入驻资料
	 * 
	 * @return
	 */
	@GetMapping("sjrz-txzl")
	public String ruZhu() {
		return "qianTai/sjrz-txzl";
	}

	@GetMapping("toJianDing")
	public String toJianDingApply(Integer num) {
		switch (num) {
			case 1:
				return "qianTai/sjzx-zjyjd";
			case 2:
				return "qianTai/sjzx-wzxjd";
			case 3:
				return "qianTai/sjzx-lxzjjd";
			case 4:
				return "qianTai/sjzx-hyfyjd";
			case 5:
				return "qianTai/sjzx-xxzyjd";
			default:
				return "/sjzx/index";
		}
	}
	@GetMapping("shop")
	public String toShop() {
		return "qianTai/shop";
	}

}
