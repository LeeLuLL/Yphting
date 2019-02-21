package com.accp.t4.action.wxxAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.accp.t4.util.file.Upload;
import com.mchange.v2.beans.swing.BoundButtonUtils;
import com.accp.t4.biz.wxxBiz.RuZhuBiz;
import com.accp.t4.entity.wxxEntity.GoldNotes;
import com.accp.t4.entity.wxxEntity.News;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.Sharea;
import com.accp.t4.entity.wxxEntity.User;

@Controller
@RequestMapping("/c/wxx/ruzhu")
@SuppressWarnings("all")
public class RuZhuServlet {
	@Autowired
	private RuZhuBiz biz;

	// 查询服务类别
	@GetMapping("selectServiceType")
	public String selectServiceType(HttpSession session) {
		session.setAttribute("shareaList", biz.selectSharea(null));
		session.setAttribute("liveCityList", biz.selectSharea("2"));
		session.setAttribute("servicetypeList", biz.selectServiceType());
		session.setAttribute("languagetypeList", biz.selectLanguageType());
		session.setAttribute("majortypeList", biz.selectMajorType());
		session.setAttribute("bond", biz.selectBound());
		return "redirect:/view/sjrz-txzl";
	}

	// 查询地址
	@GetMapping("selectSharea")
	@ResponseBody
	public List<Sharea> selectSharea(HttpSession session, String pId) {
		session.setAttribute("shareaList", biz.selectSharea(pId));
		System.out.println(biz.selectSharea(pId));
		return biz.selectSharea(pId);
	}

	// 商家入驻-填写资料
	@PostMapping("sjrz-txzl")
	public String merchantApply(HttpSession session, User user, String bzj, String serviceID, MultipartFile shopimgData,
			MultipartFile identitypositiveimgData, MultipartFile identitynegativeimgData,
			MultipartFile identityhandimgData) {
		User loginUser = (User) session.getAttribute("USER"); // 登录用户
		float bond = biz.selectBound(); // 入驻缴纳保证金金额要求
		if (bzj.equals("0")) { // 正式入驻
			if (600 >= bond) { // 如果当前登录用户的金额足够缴纳保证金
				if (serviceID.split(",").length == 2) { // 如果用户选择的服务类别为两个
					user.setFirstserviceid(Integer.parseInt(serviceID.split(",")[0]));
					user.setSecondserviceid(Integer.parseInt(serviceID.split(",")[1]));
				} else {
					user.setFirstserviceid(Integer.parseInt(serviceID));
				}
				try {
					String shopimgDataFName = Upload.uploadFile(shopimgData); // 商家店铺图片
					String identitypositiveimgDataFName = Upload.uploadFile(identitypositiveimgData); // 身份证正面照
					String identitynegativeimgDataFName = Upload.uploadFile(identitynegativeimgData); // 身份证反面照
					String identityhandimgDataFName = Upload.uploadFile(identityhandimgData); // 手持身份证正面照
					user.setShopimg(shopimgDataFName); // 设置数据库存储图片路径
					user.setIdentitypositiveimg(identitypositiveimgDataFName);
					user.setIdentitynegativeimg(identitynegativeimgDataFName);
					user.setIdentityhandimg(identityhandimgDataFName);
					user.setUserid(25);// 当前登录用户编号赋给修改对象
					// user.setUserid(loginUser.getUserid());// 当前登录用户编号赋给修改对象
				} catch (IllegalStateException | IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if (biz.merchantApply(user, bond) > 0) {// 商家入驻受影响行数
					GoldNotes gold = new GoldNotes(25, "商家入驻缴纳保证金", Float.parseFloat("-500"), 1);
					// GoldNotes gold = new GoldNotes(loginUser.getUserid(), "商家入驻缴纳保证金",
					// Float.parseFloat("-500"), 1);
					biz.saveGoldNote(gold);
					News news = new News(25, "您好，您已成功提交商家入驻的申请，请等待管理员审核。");
					// News news = new News(loginUser.getUserid(), "您好，您已成功提交商家入驻的申请，请等待管理员审核。");
					biz.sendNews(news);
					return "redirect:/view/sjrz-shzl";
				} else {
					return "redirect:/Public/error/500.html";
				}
			} else {
				return "redirect:/Public/error/500.html";
			}
		} else { // 免费入驻
			if (serviceID.split(",").length == 2) { // 如果用户选择的服务类别为两个
				user.setFirstserviceid(Integer.parseInt(serviceID.split(",")[0]));
				user.setSecondserviceid(Integer.parseInt(serviceID.split(",")[1]));
			} else {
				user.setFirstserviceid(Integer.parseInt(serviceID));
			}
			try {
				String shopimgDataFName = Upload.uploadFile(shopimgData); // 商家店铺图片
				String identitypositiveimgDataFName = Upload.uploadFile(identitypositiveimgData); // 身份证正面照
				String identitynegativeimgDataFName = Upload.uploadFile(identitynegativeimgData); // 身份证反面照
				String identityhandimgDataFName = Upload.uploadFile(identityhandimgData); // 手持身份证正面照
				user.setShopimg(shopimgDataFName); // 设置数据库存储图片路径
				user.setIdentitypositiveimg(identitypositiveimgDataFName);
				user.setIdentitynegativeimg(identitynegativeimgDataFName);
				user.setIdentityhandimg(identityhandimgDataFName);
				user.setUserid(25);// 当前登录用户编号赋给修改对象
				// user.setUserid(loginUser.getUserid());// 当前登录用户编号赋给修改对象
				bond = 0;
				user.setExperience(6);
				user.setExperiencestatus(false);
			} catch (IllegalStateException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (biz.merchantApply(user, bond) > 0) {// 商家入驻受影响行数
				News news = new News(25, "您好，您已成功提交商家入驻的申请，请等待管理员审核。");
				// News news = new News(loginUser.getUserid(), "您好，您已成功提交商家入驻的申请，请等待管理员审核。");
				biz.sendNews(news);
				return "redirect:/view/sjrz-shzl";
			} else {
				return "redirect:/Public/error/500.html";
			}
		}
	}
}
