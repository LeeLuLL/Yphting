package com.accp.t4.action.wxxAction;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.t4.biz.wxxBiz.LoginBiz;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.User;
import com.accp.t4.util.file.MyPicConfig;
import com.accp.t4.util.file.Upload;

@Controller
@RequestMapping("/c/wxx/login")
public class LoginServlet {
	@Autowired
	private LoginBiz biz;
	
	//修改密码
	@PostMapping("updPwd")
	public String updatePwd(HttpSession session,String password) {
//		User user = (User)session.getAttribute("USER");
//		String userEmail = user.getContactmailbox();
		String userEmail = "2238688103@qq.com";
		int i = biz.updatePwd(userEmail, password);
		if(i>0) {
			return "/qianTai/szy-login";
		}else {
			return "/qianTai/zhsz-xgmm";
		}
	}
	
	//查询当前登录用户
	@GetMapping("getUser")
	public String queryLoginUser(HttpSession session,int uId) {
		User user = biz.queryLoginUser(uId);
		session.setAttribute("USER", user);
		return "/qianTai/zhsz-grzl";
	}
	
	//修改用户头像
	@PostMapping("updUserImg")
	public String updateUserImg(HttpSession session,@RequestParam("img") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				Integer userID=((User)session.getAttribute("USER")).getUserid(); //用户编号
				String url = Upload.uploadFile(file); //图片上传路径
				biz.updateUserImg(url, userID);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		Integer userID=((User)session.getAttribute("USER")).getUserid(); //用户编号
		return "redirect:/c/wxx/login/getUser?uId="+userID;
	}
	
	//修改用户信息 - 个人资料
	@PostMapping("updUserInfo")
	public String updateUserInfo(HttpSession session,User user){
		if(biz.updUserInfo(user)>0) {
			Integer userID=((User)session.getAttribute("USER")).getUserid();
		}
		Integer userID=((User)session.getAttribute("USER")).getUserid(); //用户编号
		return "redirect:/c/wxx/login/getUser?uId="+userID;
	}
	
	//修改店铺信息
	@PostMapping("updDpxx")
	public String updateUserDpxx(HttpSession session,User user,@RequestParam("thumb") MultipartFile file1,@RequestParam("idcardpic1") MultipartFile file2,@RequestParam("idcardpic2") MultipartFile file3,@RequestParam("vippic") MultipartFile file4) throws IllegalStateException, IOException {
		if(file1.getSize()!= 0) { //店铺图片
			user.setShopimg(Upload.uploadFile(file1));
		}
		if(file2.getSize()!= 0) { //身份证件正面照
			user.setIdentitypositiveimg(Upload.uploadFile(file2));
		}
		if(file3.getSize()!= 0) { //身份证件反面照
			user.setIdentitynegativeimg(Upload.uploadFile(file3));
		}
		if(file4.getSize()!= 0) { //身份证件手持照
			user.setIdentityhandimg(Upload.uploadFile(file4));
		}
		Integer userID=((User)session.getAttribute("USER")).getUserid();
		user.setUserid(userID);
		biz.updateUserDpxx(user);
		return "redirect:/c/wxx/login/getUser?uId="+userID;
	}
}
