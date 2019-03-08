package com.accp.t4.action.lgbAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.accp.t4.biz.lgbBiz.InvitationBiz;
import com.accp.t4.entity.lgbEntity.Forummanagement;
import com.accp.t4.vo.lgbVO.postVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/lgbinvitation")
public class InvitationAction {

	@Autowired
	private InvitationBiz ib;
	//查询帖子
	
	/*@GetMapping("show")
	public String show() {
		return "houTai/0";
	}*/
	@GetMapping("getlist")
	public String getinvitation(String title,String fmname,Integer PageNum,Integer PageSize,Model model) {
		if(title==null||title=="") {
			title=null;
		}
		if(fmname==null||fmname=="") {
			fmname=null;
		}else if(fmname.equals("所有的")) {
			fmname=null;
		}
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		System.out.println(fmname);
		System.out.println(title);
		PageInfo<postVo> pageinfo=ib.queryallpost(PageNum, PageSize,title,fmname);
		List<Forummanagement> listinfo=ib.queryfmname();
		model.addAttribute("PAGE_INFO", pageinfo);
		model.addAttribute("LIST_INFO", listinfo);
		return "houTai/0";
	}
	
	@GetMapping("/querypost")
	public String querypost(int postid,Model model) {
		postVo querypost=ib.querypost(postid);
		System.out.println(querypost);
		model.addAttribute("querypost", querypost);
		return "houTai/zixunguanli";
	}
	

	//cx修改
	@GetMapping("querypostbyid")
	public String querypostbyid(int postid,Model model) {
		postVo postbyid=ib.querypost(postid);
		System.out.println("111"+postid);
		model.addAttribute("querypost", postbyid);
		return "houTai/zixunguanli";
	}
	//批量删除帖子
	/*@GetMapping("deletelist")
	public String deleteinvitation(int [] postid) {
		ib.deletechoose(postid);
		return "redirect:/lgbinvitation/getlist?PageNum=1&PageSize=10";
	}*/
	@DeleteMapping("deletelist/{postid}")
	public Map<String, String> deleteCommentmanagement(@PathVariable String postid) {
		Map<String, String> message = new HashMap<String, String>();
		String arrays[]=postid.split(",");
		for (String temp : arrays) {
			/*biz.deleteEvaluationService(Integer.valueOf(temp));*/
			ib.deletechoose(Integer.valueOf(temp));
		}
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	
	
	//修改帖子
	@GetMapping("updatepost")
	public String updatepost(postVo postvo) {
		ib.updatepost(postvo);
		return "redirect:/lgbinvitation/getlist?PageNum=1&PageSize=10";
	}
	//动态下拉框,查询帖子板块
	@GetMapping("queryplate")
	public String queryplate(Model model) {
		List<Forummanagement> listinfo=ib.queryfmname();
		System.out.println(listinfo);
		model.addAttribute("LIST_INFO", listinfo);
		return "houTai/blog";
	}
	//删除帖子版块
	/*@GetMapping("deletefor")
	public String deletefor(int fmid) {
		System.out.println(fmid);
		ib.deletefor(fmid);
		return "redirect:/lgbinvitation/queryplate";
	}*/
	
	@DeleteMapping("deletefor/{fmid}")
	public Map<String, String> deletefor(@PathVariable String fmid) {
		System.out.println(00000);
		Map<String, String> message = new HashMap<String, String>();
		String arrays[]=fmid.split(",");
		for (String temp : arrays) {
			/*biz.deleteEvaluationService(Integer.valueOf(temp));*/
			ib.deletefor(Integer.valueOf(temp));
		}
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	
	//跳转栏目新增界面
	@GetMapping("tzadd")
	public String add() {
		return "houTai/addtiezibanzhupaixu";
	}
	//新增栏目
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public String addBill(@RequestBody Forummanagement air) {
		try {
			ib.insetfor(air);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}
	
	
}
