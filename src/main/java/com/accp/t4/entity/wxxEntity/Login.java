package com.accp.t4.entity.wxxEntity;

public class Login {
	public Login() {
		super();
	}
	
	public Login(int loginId, int userId, String opentId, int loginType, String userEmail, String userPwd) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.opentId = opentId;
		this.loginType = loginType;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
	}
	
	private int loginId; //登录方式
	private int userId; //用户编号
	private String opentId; //第三方登录编号
	private int loginType; //登录方式
	private String userEmail; //用户邮箱
	private String userPwd; //用户密码
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOpentId() {
		return opentId;
	}
	public void setOpentId(String opentId) {
		this.opentId = opentId;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}
