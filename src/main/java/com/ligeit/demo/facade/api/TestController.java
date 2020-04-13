package com.ligeit.demo.facade.api;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ligeit.demo.biz.domain.model.UserInfoDomain;
import com.ligeit.demo.biz.service.impl.UserServiceImpl;
import com.ligeit.demo.facade.model.request.AddUserRequest;
import com.ligeit.demo.infrastructure.commons.ResultData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@Autowired  
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public ResultData defaultMessage(@Valid AddUserRequest addUserRequest, BindingResult result) {
		log.info("新增用户信息：{}",addUserRequest);
		//1.参数校验
		
		//2.数据组装
		UserInfoDomain userInfoDomain = new UserInfoDomain();
		BeanUtils.copyProperties(addUserRequest,userInfoDomain);
		
		//3.业务编排
		userServiceImpl.addUserInfo(userInfoDomain);
		
		//4.参数响应
		return ResultData.getSuccessResult();
		 
	}
}
