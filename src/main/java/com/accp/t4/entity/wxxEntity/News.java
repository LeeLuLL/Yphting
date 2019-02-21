package com.accp.t4.entity.wxxEntity;

import java.sql.Timestamp;

/**
 * 消息记录
 * @author dell
 *
 */
public class News {
	public News() {
		super();
	}
	
	public News(int addRessee, String content) {
		super();
		this.addRessee = addRessee;
		this.content = content;
	}
	
	public News(int newsID, int theSender, int addRessee, String content, Timestamp sendingTime, int readState,
			int newsType, int messageGroup) {
		super();
		this.newsID = newsID;
		this.theSender = theSender;
		this.addRessee = addRessee;
		this.content = content;
		this.sendingTime = sendingTime;
		this.readState = readState;
		this.newsType = newsType;
		this.messageGroup = messageGroup;
	}
	
	private int newsID; //消息id
	private int theSender; //发件人编号
	private int addRessee; //收件人编号
	private String content; //内容
	private Timestamp sendingTime; //发送时间
	private int readState; //是否已读
	private int newsType; //消息类型
	private int messageGroup; //消息消息组编号
	
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public int getTheSender() {
		return theSender;
	}
	public void setTheSender(int theSender) {
		this.theSender = theSender;
	}
	public int getAddRessee() {
		return addRessee;
	}
	public void setAddRessee(int addRessee) {
		this.addRessee = addRessee;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getSendingTime() {
		return sendingTime;
	}
	public void setSendingTime(Timestamp sendingTime) {
		this.sendingTime = sendingTime;
	}
	public int getReadState() {
		return readState;
	}
	public void setReadState(int readState) {
		this.readState = readState;
	}
	public int getNewsType() {
		return newsType;
	}
	public void setNewsType(int newsType) {
		this.newsType = newsType;
	}
	public int getMessageGroup() {
		return messageGroup;
	}
	public void setMessageGroup(int messageGroup) {
		this.messageGroup = messageGroup;
	}
}
