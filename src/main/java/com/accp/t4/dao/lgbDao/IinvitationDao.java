package com.accp.t4.dao.lgbDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.lgbEntity.Forummanagement;
import com.accp.t4.vo.lgbVO.postVo;

public interface IinvitationDao {

		//查询帖子
		public List<postVo> queryall(@Param("title") String title,@Param("fmname") String fmname);
		//批量删除帖子
		public int deletechoose(@Param("postid") Integer postid);
		//动态下拉框,查询帖子板块
		public List<Forummanagement> queryfmname();
		//修改帖子
		public int updatepost(@Param("postvo")postVo postvo);
		//查询修改帖子
		public postVo querypost(@Param("postid") int postid);
		//删除帖子版块
		public int deletefor(@Param("fmid")int fmid);
		//新增栏目
		public int insertfor(@Param("foru") Forummanagement foru);
		
}
