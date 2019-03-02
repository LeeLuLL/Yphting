package com.accp.t4.dao.llDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.llEntity.Appraisalapply;
import com.accp.t4.entity.llEntity.Services;
import com.accp.t4.vo.llVO.AppraisalapplyVO;

public interface ISJZXDao {
	/**
	 * 查询发布的服务
	 * @param userId
	 * @return
	 */
	public List<Services> selectServices(@Param("userId")Integer userId);
	/**
	 * 查询鉴定申请
	 * @param userId
	 * @return
	 */
	public List<AppraisalapplyVO> selectAppraisalapplys(@Param("userId")Integer userId,@Param("oneid")Integer oneid,@Param("twoid")Integer twoid);
	/**
	 * 鉴定申请
	 * @param apply
	 * @return
	 */
	public int addApply(@Param("pojo")Appraisalapply apply);
}
