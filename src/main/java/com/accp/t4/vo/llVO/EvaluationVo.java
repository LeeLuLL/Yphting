package com.accp.t4.vo.llVO;
/**
 * 我的评价
 * @author Administrator
 *
 */
import java.util.Date;

public class EvaluationVo {
	private Integer serviceAppraiseID;
	private Integer evaluationservice;
	private Integer userID;
	private String serviceAppraiseContent;
	private Date serviceAppraiseDate;
	private Integer serviceAppraiseLevel;
	private Integer serviceAppraisePID;
	private String serviceTitle;
	private String serviceFuTitle;
	private String serviceCoverImg;
	public Integer getServiceAppraiseID() {
		return serviceAppraiseID;
	}
	public void setServiceAppraiseID(Integer serviceAppraiseID) {
		this.serviceAppraiseID = serviceAppraiseID;
	}
	public Integer getEvaluationservice() {
		return evaluationservice;
	}
	public void setEvaluationservice(Integer evaluationservice) {
		this.evaluationservice = evaluationservice;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getServiceAppraiseContent() {
		return serviceAppraiseContent;
	}
	public void setServiceAppraiseContent(String serviceAppraiseContent) {
		this.serviceAppraiseContent = serviceAppraiseContent;
	}
	public Date getServiceAppraiseDate() {
		return serviceAppraiseDate;
	}
	public void setServiceAppraiseDate(Date serviceAppraiseDate) {
		this.serviceAppraiseDate = serviceAppraiseDate;
	}
	public Integer getServiceAppraiseLevel() {
		return serviceAppraiseLevel;
	}
	public void setServiceAppraiseLevel(Integer serviceAppraiseLevel) {
		this.serviceAppraiseLevel = serviceAppraiseLevel;
	}
	public Integer getServiceAppraisePID() {
		return serviceAppraisePID;
	}
	public void setServiceAppraisePID(Integer serviceAppraisePID) {
		this.serviceAppraisePID = serviceAppraisePID;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public EvaluationVo() {
		super();
	}
	
}
