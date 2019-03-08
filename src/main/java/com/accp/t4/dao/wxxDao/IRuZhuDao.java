package com.accp.t4.dao.wxxDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.wxxEntity.GoldNotes;
import com.accp.t4.entity.wxxEntity.LanguageType;
import com.accp.t4.entity.wxxEntity.MajorType;
import com.accp.t4.entity.wxxEntity.News;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.Sharea;
import com.accp.t4.entity.wxxEntity.User;

/**
 * 商家入驻
 * @author dell
 */
public interface IRuZhuDao {
	/**
	 * 查询服务类别
	 * @return
	 */
	public List<ServiceType> selectServiceType(@Param("stPid") String stPid);
	
	/**
	 * 查询地址
	 * @param pId 父级编号
	 * @return
	 */
	public List<Sharea> selectSharea(@Param("pId") String pId);
	
	/**
	 * 查询服务语言
	 * @return
	 */
	public List<LanguageType> selectLanguageType();
	
	/**
	 * 查询擅长专业
	 * @return
	 */
	public List<MajorType> selectMajorType();
	
	/**
	 * 查询开店所需保证金
	 * @return
	 */
	public int selectBound();
	
	/**
	 * 商家入驻-填写资料
	 * @param user 用户
	 * @param bond 保证金
	 * @return
	 */
	public int merchantApply(@Param("obj") User user,@Param("bond") float bond);
	
	/**
	 * 添加金币流向记录
	 * @param gold
	 * @return
	 */
	public int saveGoldNote(@Param("gold") GoldNotes gold);
	
	/**
	 * 发送系统消息
	 * @param news
	 * @return
	 */
	public int sendNews(@Param("news") News news);
}
