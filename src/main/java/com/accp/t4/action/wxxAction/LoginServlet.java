package com.accp.t4.action.wxxAction;

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
import org.springframework.web.bind.annotation.RestController;

import com.accp.t4.biz.wxxBiz.LoginBiz;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.User;

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
}
