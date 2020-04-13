package com.ligeit.demo.biz.domain.repository.impl;

import org.springframework.stereotype.Component;

import com.ligeit.demo.biz.domain.model.UserInfoDomain;
import com.ligeit.demo.biz.domain.repository.Repository;

@Component
public class UserLinkRepository implements Repository<UserInfoDomain>{

	@Override
	public void add(UserInfoDomain model) {
		// TODO Auto-generated method stub
	}

	@Override
	public UserInfoDomain get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(UserInfoDomain model) {
		// TODO Auto-generated method stub
	}

}
