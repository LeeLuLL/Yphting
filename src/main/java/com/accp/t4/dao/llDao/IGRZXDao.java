package com.accp.t4.dao.llDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.vo.llVO.EvaluationVo;
import com.accp.t4.vo.llVO.Goldnotes;
import com.accp.t4.vo.llVO.Integral;
import com.accp.t4.vo.llVO.OrderVO;
import com.accp.t4.vo.llVO.Refund;
import com.accp.t4.vo.llVO.UserVo;

public interface IGRZXDao {
	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public UserVo selectUser(@Param("userId")Integer userId);
	
	/**
	 * 查询预订的服务信息
	 * @param userId
	 * @return
	 */
	public List<OrderVO> selectOrder(@Param("userId")Integer userId);
	/**
	 * 查询金币
	 * @param userId
	 * @return
	 */
	public List<Goldnotes> selectMoney(@Param("userId")Integer userId);
	/**
	 * 查询积分记录
	 * @param userId
	 * @return
	 */
	public List<Integral> selectJiFen(@Param("userId")Integer userId);
	/**
	 * 我的退款
	 * @param userId
	 * @return
	 */
	public List<Refund> selectRefunds(@Param("userId")Integer userId);
	/**
	 * 我的评价
	 * @param userId
	 * @return
	 */
	public List<EvaluationVo> selectEvaluation(@Param("userId")Integer userId);
}
