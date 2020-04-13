package com.ligeit.demo.facade.model.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户参数响应
 * @author ligeit
 *
 */
@Data
public class UserResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userNo;
	
	private String name;
	
	private String sex;
	
	private int age;
}
