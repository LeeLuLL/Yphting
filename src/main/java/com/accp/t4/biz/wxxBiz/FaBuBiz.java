package com.accp.t4.biz.wxxBiz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.wxxDao.IFaBuDao;
import com.accp.t4.entity.wxxEntity.Services;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, isolation = Isolation.READ_COMMITTED)
public class FaBuBiz {
	@Autowired
	private IFaBuDao dao;
	
	//发布服务
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public int addService(Services service) {
		return dao.addService(service);
	}
	
	//查询资源类别
	public List<Resource> selectResource(){
		return dao.selectResource();
	}
	
	//查询单个服务信息
	public Services selectServiceOne(int sId) {
		return dao.selectServiceOne(sId);
	}
}
