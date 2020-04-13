package com.ligeit.demo.biz.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfoDomain {

	private String name;
	
	private int age;
	
	private String linkName;
	
	private String linkPhone;
	
	private String linkRelation;
	
	private String IDCard;
	
	private Date birthday;
	
	private String sex;
	
	private String address;
	
	public void setIDCardInfo() {
		//根据IDCard获取性别、生日等信息--》公用方法
		this.birthday = new Date();
		this.sex = "F";
		this.address = "";
	}
	
	public boolean phoneIsBlack() {
		//判断手机号是否黑名单
		return false;
	}
}
