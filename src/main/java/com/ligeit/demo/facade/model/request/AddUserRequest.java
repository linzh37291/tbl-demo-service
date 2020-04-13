package com.ligeit.demo.facade.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 新增用户请求参数
 * @author ligeit
 *
 */
@Data
public class AddUserRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull(message = "参数[token]不能为空")
	private String token;
	
	@NotNull(message = "参数[name]不能为空")
	private String name;
	
	@Max(100)
	@Min(1)
	@NotNull(message = "参数[age]不能为空")
	private int age;
	
	/**
	 * 联系人
	 */
	private String linkName;
	
	/**
	 * 联系电话
	 */
	private String linkPhone;
	
	/**
	 * 联系人关系
	 */
	private String linkRelation;
	
	/**
	 * 身份证号
	 */
	private String IDCard;
}
