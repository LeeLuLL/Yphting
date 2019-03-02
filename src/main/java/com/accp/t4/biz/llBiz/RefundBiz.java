package com.accp.t4.biz.llBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.llDao.IRefundDao;
import com.accp.t4.entity.llEntity.Refund;
import com.accp.t4.vo.llVO.RefundVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class RefundBiz {
	@Autowired
	private IRefundDao refundDao;
	/**
	 * 退款列表
	 * @param num
	 * @param userId
	 * @param merchantId
	 * @return
	 */
	public PageInfo<RefundVO> selectRefunds(Integer num,Integer userId,Integer merchantId){
		PageHelper.startPage(num, 6);
		return new PageInfo<RefundVO>(refundDao.selectRefunds(userId, merchantId));
	}
	/**
	 * 退款详情
	 * @param refundId
	 * @return
	 */
	public RefundVO selectRefundDetail(Integer refundId) {
		return refundDao.selectRefundDetail(refundId);
	}
	/**
	 * 修改退款
	 * @param refund
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateRefund(Refund refund) {
		return refundDao.updateRefund(refund);
	}
	
}
