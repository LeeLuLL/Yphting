package com.accp.t4.biz.llBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.llDao.IUserDao;
import com.accp.t4.vo.llVO.UserVo;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UserBiz {
	@Autowired
	private IUserDao dao;
	/**
	 * 查询用户
	 * @param userId
	 * @return
	 */
	public UserVo selectUser(Integer userId) {
		return dao.selectUser(userId);
	}
}
