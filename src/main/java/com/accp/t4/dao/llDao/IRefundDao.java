package com.accp.t4.dao.llDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.llEntity.Refund;
import com.accp.t4.vo.llVO.RefundVO;

public interface IRefundDao {
	/**
	 * 查询退款列表
	 * @param userId
	 * @param merchantId
	 * @return
	 */
	public List<RefundVO> selectRefunds(@Param("userId")Integer userId,@Param("merchantId")Integer merchantId);
	/**
	 * 退款详情
	 * @param refundId
	 * @return
	 */
	public RefundVO selectRefundDetail(@Param("refundId")Integer refundId);
	
	/**
	 * 修改退款信息
	 * @param refund
	 * @return
	 */
	public int updateRefund(@Param("refund")Refund refund);
	
}
