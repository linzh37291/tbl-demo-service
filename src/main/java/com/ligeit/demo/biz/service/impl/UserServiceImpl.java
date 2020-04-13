package com.ligeit.demo.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligeit.demo.biz.domain.model.UserInfoDomain;
import com.ligeit.demo.biz.domain.repository.impl.UserBaseInfoRepository;
import com.ligeit.demo.biz.domain.repository.impl.UserLinkRepository;
import com.ligeit.demo.biz.service.IUserService;
import com.ligeit.demo.infrastructure.commons.BizErrorCode;
import com.ligeit.demo.infrastructure.commons.BusinessException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserBaseInfoRepository userBaseInfoRepository;
	
	@Autowired
	private UserLinkRepository userLinkRepository;
	
	@Override
	public void addUserInfo(UserInfoDomain userInfoDomain) {
		userInfoDomain.setIDCardInfo();
		
		if(userInfoDomain.phoneIsBlack()) {
			throw new BusinessException(BizErrorCode.UNKNOWN_EXCEPTION);
		}
		
		userBaseInfoRepository.add(userInfoDomain);
		userLinkRepository.add(userInfoDomain);
		
	}

}
