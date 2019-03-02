package com.accp.t4.dao.llDao;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.vo.llVO.UserVo;

public interface IUserDao {
	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public UserVo selectUser(@Param("userId")Integer userId);
}
