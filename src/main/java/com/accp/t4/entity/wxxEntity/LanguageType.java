package com.accp.t4.entity.wxxEntity;

/**
 * 服务语言
 * @author dell
 */
public class LanguageType {
	public LanguageType() {
		super();
	}
	
	public LanguageType(int languageID, String languageName) {
		super();
		this.languageID = languageID;
		this.languageName = languageName;
	}
	
	private int languageID; //服务语言编号
	private String languageName; //服务语言名称
	
	public int getLanguageID() {
		return languageID;
	}
	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
}
