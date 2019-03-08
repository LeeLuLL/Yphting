package com.accp.t4.biz.wxxBiz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.accp.t4.dao.wxxDao.IRuZhuDao;
import com.accp.t4.entity.wxxEntity.GoldNotes;
import com.accp.t4.entity.wxxEntity.LanguageType;
import com.accp.t4.entity.wxxEntity.MajorType;
import com.accp.t4.entity.wxxEntity.News;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.Sharea;
import com.accp.t4.entity.wxxEntity.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, isolation = Isolation.READ_COMMITTED)
public class RuZhuBiz {
	@Autowired
	private IRuZhuDao dao;
	
	//查询服务类别
	public List<ServiceType> selectServiceType(String stPid){
		return dao.selectServiceType(stPid);
	}
	
	//查询地址
	public List<Sharea> selectSharea(String pId){
		return dao.selectSharea(pId);
	}
	
	//查询服务语言
	public List<LanguageType> selectLanguageType(){
		return dao.selectLanguageType();
	}
	
	//查询擅长专业
	public List<MajorType> selectMajorType(){
		return dao.selectMajorType();
	}
	
	//查询开店所需保证金
	public int selectBound() {
		return dao.selectBound();
	}
	
	//商家入驻-填写资料
	public int merchantApply(User user,float bond) {
		return dao.merchantApply(user, bond);
	}
	
	//添加金币流向记录
	public int saveGoldNote(GoldNotes gold) {
		return dao.saveGoldNote(gold);
	}
	
	//发送系统消息
	public int sendNews(News news) {
		return dao.sendNews(news);
	}
}
