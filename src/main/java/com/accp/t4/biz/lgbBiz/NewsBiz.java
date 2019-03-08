package com.accp.t4.biz.lgbBiz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.lgbDao.NewsDao;
import com.accp.t4.entity.lgbEntity.News;
 import com.accp.t4.entity.lgbEntity.User;
import com.accp.t4.vo.lgbVO.NewsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

 @Service
 @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class NewsBiz {

	@Autowired
	private NewsDao dao;
	
	/**
	 * 根据用户id和消息类型(站内和系统)查询消息
	 * @param userid
	 * @param newstype
	 * @return
	 */
	/*public List<News> InMail(int userid,int newstype){
		return newsdao.InMail(userid, newstype);
	}*/
	
	/**
	 * 查询当前用户
	 * @param userID
	 * @return
	 */
	public User queryUser(Integer userID){
		return dao.queryUser(userID);
	}
	
	/**
	 * 系统分页查询
	 * @param userID
	 * @param newsType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<News>  queryNewPageInfo(Integer userID,Integer newsType,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<>(dao.queryXtNews(userID, newsType));
	}
	/**
	 * 修改已读
	 * @param newsID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateXtNews(String newsID) {
		return dao.updateXtNews(newsID);
	}
	/**
	 * 删除系统信息
	 * @param newsID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int deleteNews(String newsID) {
		return dao.deleteNews(newsID);
	}
	
	/**
	 * 站内信分页查询
	 * @param userID
	 * @param newsType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<NewsVo>  queryZnxNewsPageInfo(Integer userID,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		System.out.println("biz"+userID);
		return new PageInfo<>(dao.queryZnxNews(userID));
	}
	/**
	 * 修改站内信信息
	 * @param groupID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateZnxNews(String groupID) {
		return dao.updateZnxNews(groupID);
	}
	/**
	 * 删除站内信
	 * @param newsID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int deleteZnxNews(String groupID) {
		return dao.deleteZnxNews(groupID);
	}
	/**
	 * 查询站内信详情
	 * @param userID
	 * @return
	 */
	public List<NewsVo> queryZnxXq(String groupID){
		return dao.queryZnxXq(groupID);
	}
	/**
	 * 新增站内信
	 * @param news
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean saveZnx(News news) {
		return dao.saveZnx(news)>0;
	}
	/**
	 * 查询所有信息
	 * @param userID
	 * @return
	 */
	public List<News> queryAllNews(Integer userID){
		return dao.queryAllNews(userID);
	}
	/**
	 * 新增系统消息
	 * @param userID 用户ID
	 * @param content 内容
	 * @return
	 */
	public boolean saveXtxx(Integer userID,String content) {
		return dao.saveXtxx(userID, content)>0;
	}
}
