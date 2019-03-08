package com.accp.t4.biz.wxxBiz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.wxxDao.ILoginDao;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, isolation = Isolation.READ_COMMITTED)
public class LoginBiz {
	@Autowired
	private ILoginDao dao;
	
	//修改用户密码
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public int updatePwd(String userEmail,String userPwd) {
		return dao.updatePwd(userEmail, userPwd);
	}
	
	//查询当前登录用户
	public User queryLoginUser(int uId) {
		return dao.queryLoginUser(uId);
	}
	
	//修改用户头像
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public int updateUserImg(String userImgPath,Integer userID) {
		return dao.updateUserImg(userImgPath, userID);
	}
	
	//修改用户信息 - 个人资料
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public int updUserInfo(User user) {
		return dao.updUserInfo(user);
	}
	
	//修改店铺信息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public int updateUserDpxx(User user) {
		return dao.updateUserDpxx(user);
	}
}
