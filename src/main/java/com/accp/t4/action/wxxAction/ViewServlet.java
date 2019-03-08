package com.accp.t4.action.wxxAction;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.t4.biz.wxxBiz.FaBuBiz;
import com.accp.t4.biz.wxxBiz.RuZhuBiz;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/view/")
public class ViewServlet {
	@Autowired
	private RuZhuBiz biz;
	
	@Autowired
	private FaBuBiz fbiz;
	
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
	
	//修改密码
	@GetMapping("updPwd")
	public String goToUpdate() {
		return "qianTai/zhsz-xgmm";
	}
	
	//账户设置-店铺信息
	@GetMapping("zhsz-dpxx")
	public String goToDianPu(Model model) {
		model.addAttribute("servicetypeList", biz.selectServiceType(""));
		model.addAttribute("languagetypeList", biz.selectLanguageType());
		model.addAttribute("majortypeList", biz.selectMajorType());
		return "qianTai/zhsz-dpxx";
	}
	
	//首页
	@GetMapping("fw-sy")
	public String goToIndex() {
		return "qianTai/fw-sy";
	}
	
	//发布服务-自驾游
	@GetMapping("sjzx-zjyfbfw")
	public String goToZJYFaBu(Model model) {
		model.addAttribute("shareaList", biz.selectSharea(null));
		return "qianTai/sjzx-zjyfbfw";
	}
	
	//发布服务-微整形
	@GetMapping("sjzx-wzxfbfw")
	public String goToWZXFaBu(Model model) {
		model.addAttribute("shareaList", biz.selectSharea(null));
		return "qianTai/sjzx-wzxfb";
	}
	
	//发布服务-学习资源
	@GetMapping("sjzx-xxzyfbfw")
	public String goToXXZLFaBu(Model model) {
		model.addAttribute("shareaList", biz.selectSharea(null));
		model.addAttribute("resouroeList", fbiz.selectResource());
		return "qianTai/sjzx-xxzyfb";
	}
	
	//发布服务-留学介绍
	@GetMapping("sjzx-fbfw")
	public String goToLXZJFaBu(Model model,Integer sId) {
		model.addAttribute("shareaList", biz.selectSharea(null));
		if(sId!=0) {
			model.addAttribute("service", fbiz.selectServiceOne(sId));
		}
		return "qianTai/sjzx-fbfw";
	}
	
	//发布服务-韩语翻译
	@GetMapping("sjzx-hyfyfbfw")
	public String goToHYFYFaBu(Model model) {
		model.addAttribute("majorList", biz.selectMajorType());
		return "qianTai/sjzx-hwfyfb";
	}   
	
//	//查询单个服务
//	@GetMapping("sjzx-selOne")
//	public String goToUpdate(Model model,int sId,String url) {
//		model.addAttribute("service", fbiz.selectServiceOne(sId));
//		return "qianTai/"+url;
//	}
	
//	//裁剪图片
//	@PostMapping("jcrop")
//	public String goToJcrop(Model model,@RequestBody String data) {
//		data = data.replaceAll("&", ",");
//		data = data.replaceAll("%2F", "/");
//		//data = (String) JSON.parse(data);
//		//JSON.
//		String [] datas = data.split("=");
//		String [] newDatas;
//		
//		for (String temp : datas) {
//			
//		}
//		
//		System.out.println(data);
//		model.addAttribute("data", data);
//		return "qianTai/tojcrop";
//	}
}
