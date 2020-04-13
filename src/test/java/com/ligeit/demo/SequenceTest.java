package com.ligeit.demo;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ligeit.demo.biz.domain.model.UserInfoDomain;
import com.ligeit.demo.biz.domain.repository.impl.UserLinkRepository;
import com.ligeit.demo.biz.service.impl.UserServiceImpl;

@SpringBootTest(classes = { Application.class })
public class SequenceTest extends AbstractTestNGSpringContextTests{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test(groups = "a")
    public void test1(){
        System.out.println("test");
	}
	
	@Test(groups = "b")
    public void test4(){
		UserInfoDomain domain = new UserInfoDomain();
		userServiceImpl.addUserInfo(domain);
	}
	
	@Test(groups = "getOrder")
	public void getOrder() {
		UserLinkRepository userLinkRepository = Mockito.mock(UserLinkRepository.class);
		
	}
	
}
