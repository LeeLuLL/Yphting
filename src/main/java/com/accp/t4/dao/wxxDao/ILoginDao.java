package com.accp.t4.dao.wxxDao;

import org.apache.ibatis.annotations.Param;

public interface ILoginDao {
	/**
	 * 修改用户密码
	 * @param userEmail  用户邮箱
	 * @param userPwd   新密码
	 * @return
	 */
	public int updatePwd(@Param("userEmail") String userEmail,@Param("userPwd") String userPwd);
}
