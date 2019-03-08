package com.accp.t4.dao.wxxDao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.wxxEntity.Services;

/**
 * 发布服务
 * @author dell
 */
public interface IFaBuDao {
	/**
	 * 发布服务
	 * @param service
	 * @return
	 */
	 public int addService(@Param("services")Services service);
	 
	 /**
	  * 查询资源类别
	  * @return
	  */
	 public List<Resource> selectResource();
	 
	 /**
	  * 查询单个服务信息
	  * @param sId
	  * @return
	  */
	 public Services selectServiceOne(@Param("sId") int sId);
}
