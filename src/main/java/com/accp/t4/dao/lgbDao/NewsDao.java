package com.accp.t4.dao.lgbDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.lgbEntity.News;
import com.accp.t4.entity.lgbEntity.User;
import com.accp.t4.vo.lgbVO.NewsVo;

public interface NewsDao {

	/*//查询消信
	public List<News> InMail(@Param("userid") int userid,@Param("newstype") int newstype);*/

	/**
	 * 查询当前用户
	 * @param userID
	 * @return
	 */
	public User queryUser(@Param("userID")Integer  userID);
	
	/**
	 * 查询用户系统信息
	 * @param userID
	 * @return
	 */
	public List<News> queryXtNews(@Param("userid")Integer userID,@Param("newsType")Integer newsType);
	/**
	 * 修改系统信息已读状态
	 * @param newsID
	 * @return
	 */
	public int updateXtNews(@Param("newsID")String newsID);
	/**
	 * 删除系统信息
	 * @param newsID
	 * @return
	 */
	public int deleteNews(@Param("newsID")String newsID);
	/**
	 * 查询站内信
	 * @param userID
	 * @return
	 */
	public List<NewsVo> queryZnxNews(@Param("userID")Integer userID);
	/**
	 * 修改站内信已读状态
	 * @param groupID
	 * @return
	 */
	public int updateZnxNews(@Param("groupID")String groupID);
	/**
	 * 删除站内信
	 * @param newsID
	 * @return
	 */
	public int deleteZnxNews(@Param("groupID")String groupID);
	/**
	 * 查询站内信详情
	 * @param groupID
	 * @return
	 */
	public List<NewsVo> queryZnxXq(@Param("groupID")String groupID);
	/**
	 * 新增站内信
	 * @param news
	 * @return
	 */
	public int saveZnx(@Param("news")News news);
	/**
	 * 查询所有信息
	 * @param userID
	 * @return
	 */
	public List<News> queryAllNews(@Param("userid")Integer userID);
	/**
	 * 新增系统信息
	 * @param userID
	 * @param content
	 * @return
	 */
	public int saveXtxx(@Param("userid")Integer userID,@Param("content")String content);
}
