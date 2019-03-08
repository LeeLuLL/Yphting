package com.accp.t4.dao.wxxDao;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.wxxEntity.User;

/**
 * 账户设置
 * @author dell
 *
 */
public interface ILoginDao {
	/**
	 * 修改用户密码
	 * @param userEmail  用户邮箱
	 * @param userPwd   新密码
	 * @return
	 */
	public int updatePwd(@Param("userEmail") String userEmail,@Param("userPwd") String userPwd);
	
	/**
	 * 查询当前登录用户信息
	 * @param uId
	 * @return
	 */
	public User queryLoginUser(@Param("uId") int uId);
	
	/**
	 * 修改用户头像
	 * @param userImgPath
	 * @param userID
	 * @return
	 */
	public int updateUserImg(@Param("userImg")String userImgPath,@Param("userID")Integer  userID);
	
	/**
	 * 修改用户信息 - 个人资料
	 * @param user
	 * @return
	 */
	public int updUserInfo(@Param("u") User user);
	
	/**
	 * 修改店铺信息
	 * @param user
	 * @return
	 */
	public int updateUserDpxx(@Param("u")User user);
}
