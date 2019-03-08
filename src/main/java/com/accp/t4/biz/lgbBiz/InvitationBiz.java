package com.accp.t4.biz.lgbBiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.lgbDao.IinvitationDao;
import com.accp.t4.entity.lgbEntity.Forummanagement;
import com.accp.t4.vo.lgbVO.postVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class InvitationBiz {

	@Autowired
	private IinvitationDao iid;
	
	public PageInfo<postVo> queryallpost(Integer PageNum,Integer PageSize,String title,String fmname){
		PageHelper.startPage(PageNum, PageSize);
		System.out.println("qqq"+title);
		return new PageInfo<postVo>(iid.queryall(title,fmname));
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int deletechoose(Integer postid){
		return iid.deletechoose(postid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public List<Forummanagement> queryfmname(){
		return iid.queryfmname();
	}
	//修改
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int updatepost(postVo postvo){
		return iid.updatepost(postvo);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public List<Forummanagement> queryplate(){
		return iid.queryfmname();
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public postVo querypost(int postid){
		return iid.querypost(postid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int deletefor(int fmid){
		return iid.deletefor(fmid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int insetfor(Forummanagement foru){
		return iid.insertfor(foru);
	}
}
