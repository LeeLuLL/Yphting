package com.accp.t4.action.lgbAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.t4.biz.lgbBiz.NewsBiz;
import com.accp.t4.entity.lgbEntity.News;
import com.accp.t4.entity.lgbEntity.User;
import com.accp.t4.vo.lgbVO.NewsVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/lgb")
public class NewsAction {

	@Autowired
	private NewsBiz biz;
	
	
	
	/**
	 * 分页查询用户系统信息
	 * @param session
	 * @param newsType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/user/queryNewPageInfo",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<News> queryNewPageInfo(HttpSession session,Integer newsType,Integer pageNum,Integer pageSize){
		//Integer userID=((User)session.getAttribute("USER")).getUserid();
		return biz.queryNewPageInfo(24, newsType, pageNum, pageSize);
	}
	
	
	@GetMapping("show")
	public String show() {
		return "qianTai/xx-xtxx.html";
	}
	
	@GetMapping("show1")
	public String show1() {
		return "qianTai/xx-znx.html";
	}
	@GetMapping("yuding")
	public String yuding() {
		return "qianTai/zjw-dongtai.html";
	}
	
	/**
	 * 修改已读状态
	 * @param newsID
	 * @return
	 */
	@RequestMapping(value="/user/updateXtNews",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateXtNews(String newsID){
		Map<String,String> m=new HashMap<>();
		System.out.println(newsID);
		newsID=newsID.substring(1, newsID.length());
		System.out.println(newsID);
		String[] Ids=newsID.split(",");
		try {
			for (String id : Ids) {
				biz.updateXtNews(id);
			}
			m.put("code", "200");
		} catch (Exception e) {
			m.put("code", "500");
			m.put("msg", e.getMessage());
		}
		return m;
	}
	
	/**
	 * 删除系统消息
	 * @param newsID
	 * @return
	 */
	@RequestMapping(value="/user/deleteNews",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteNews(String newsID){
		Map<String,String> m=new HashMap<>();
		newsID=newsID.substring(1, newsID.length());
		String[] Ids=newsID.split(",");
		try {
			for (String id : Ids) {
				biz.deleteNews(id);
			}
			m.put("code", "200");
		} catch (Exception e) {
			m.put("code", "500");
			m.put("msg", e.getMessage());
		}
		return m;
	}
	/**
	 * 获取当前用户session
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/queryAUser")
	@ResponseBody
	public User queryAUser(HttpSession session) {
		if(session.getAttribute("USER")==null) {
			return null;
		}else {
			Integer userID=((User)session.getAttribute("USER")).getUserid();
			User u=biz.queryUser(userID);
			session.setAttribute("USER", u);
			return u;
		}
	}
	/**
	 * 查询用户站内信
	 * @param session
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	
	@RequestMapping(value="/user/queryZnxNewsPageInfo",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<NewsVo>  queryZnxNewsPageInfo(HttpSession session,Integer pageNum,Integer pageSize){
		//Integer userID=((User)session.getAttribute("USER")).getUserid();
		return biz.queryZnxNewsPageInfo(24, pageNum, pageSize);
	}
	/**
	 * 修改站内信状态
	 * @param groupID
	 * @return
	 */
	@RequestMapping(value="/user/updateZnxNews",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateZnxNews(String groupID) {
		Map<String,String> m=new HashMap<>();
		
		groupID=groupID.substring(1, groupID.length());
	
		String[] Ids=groupID.split(",");
		try {
			for (String id : Ids) {
				biz.updateZnxNews(id);
			}
			m.put("code", "200");
		} catch (Exception e) {
			m.put("code", "500");
			m.put("msg", e.getMessage());
		}
		return m;
	}

	/**
	 * 删除站内消息
	 * @param newsID
	 * @return
	 */
	@RequestMapping(value="/user/deleteZnxNews",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteZnxNews(String groupID){
		Map<String,String> m=new HashMap<>();
		groupID=groupID.substring(1, groupID.length());
		String[] Ids=groupID.split(",");
		try {
			for (String id : Ids) {
				biz.deleteZnxNews(id);
			}
			m.put("code", "200");
		} catch (Exception e) {
			m.put("code", "500");
			m.put("msg", e.getMessage());
		}
		return m; 
	}
	/**
	 * 查询站内信详情
	 * @param model
	 * @param groupID
	 * @return
	 */
	@RequestMapping(value="/user/queryZnxXq",method=RequestMethod.GET)
	public String queryZnxXq(Model model ,String groupID) {
		model.addAttribute("news", biz.queryZnxXq(groupID));
		//设为已读
		return "qianTai/xx-znx-xq";
	}
	/**
	 * 新增站内信
	 * @param session
	 * @param thesender
	 * @param content
	 * @param newstype
	 * @param messagegroup
	 * @return
	 */
	/*@RequestMapping(value="/user/saveZnx",method=RequestMethod.GET)
	public String saveZnx(HttpSession session,Integer thesender,String content,Integer newstype,Integer messagegroup) {
		Integer userID=((User)session.getAttribute("USER")).getUserid();
		News n=new News();
		n.setThesender(userID);
		n.setContent(content);
		n.setNewstype(newstype);
		n.setMessagegroup(messagegroup);
		n.setAddressee(thesender);
		biz.saveZnx(n);
		return "redirect:/c/lgb/user/queryZnxXq?groupID="+messagegroup+"&thesender="+thesender;
	}*/
	@RequestMapping(value="/user/saveZnx",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveZnx(HttpSession session,Integer thesender,String content,Integer newstype,Integer messagegroup) {
		Map<String,String> m=new HashMap<>();
		//Integer userID=((User)session.getAttribute("USER")).getUserid();
		News n=new News();
		n.setThesender(24);
		n.setContent(content);
		n.setNewstype(newstype);
		n.setMessagegroup(messagegroup);
		n.setAddressee(thesender);
		try {
			biz.saveZnx(n);
			m.put("code", "200");
		} catch (Exception e) {
			m.put("code", "500");
			m.put("msg", e.getMessage());
		}
		return m;
		//return "redirect:/c/qyl/user/queryZnxXq?groupID="+messagegroup+"&thesender="+thesender;
	}
	
	/**
	 * 查询所有信息
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="/user/queryAllNews",method=RequestMethod.GET)
	@ResponseBody
	public List<News> queryAllNews(HttpSession session){
		//Integer userID=((User)session.getAttribute("USER")).getUserid();
		return biz.queryAllNews(24);
	}
	/**
	 * 查询信息  商家首页
	 * @param session
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="/user/getUserBySjzx",method=RequestMethod.GET)
	public String getUserBySjzx(HttpSession session,Model model) {
		Integer userID=((User)session.getAttribute("USER")).getUserid();
		model.addAttribute("orders", orderBiz.queryUserOrder(userID, 0, -1, "", 1, 3));
		model.addAttribute("user", this.queryAUser(session));
		return "/sjzx-index.html";
	}*/
	
}
