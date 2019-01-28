package com.honglin_chen.spring_bean_scope_annotation.bean;

import org.springframework.stereotype.Component; 
import org.springframework.beans.factory.annotation.Autowired; 

@Component
public class Customer {
	/* 标记一个将要被Spring依赖注入机制自动连接到当前组件的组件 */
	@Autowired
	private Name name; 
	
	@Autowired 
	private Language language;
	
	@Autowired
	private Address address; 
	
	@Autowired 
	private Age age; 
	
	/* 通过依赖注入机制引用自动连接组件的方法实现客户Bean的方法 */
	public String getCustomerName() {
		/* 引用Name Bean的toString()方法返回用户的名字 */  
		return this.name.toString();
	}
	
	public void setCustomerName(String firstName, String lastName) {
		this.name.setFirstName(firstName);
		this.name.setLastName(lastName);
	}
	
	/* 设置客户Bean的语言环境 */ 
	public String getCustomerLanguage() {
		return this.language.getLanguage();
	}
	
	public String setCustomerLanguage(String language) {
		return this.language.setLanguage(language); 
	}
	
	/* 设置客户的地址环境 */
	public String getCustomerAddress() {
		return this.address.getAddress();
	}
	
	public void setCustomerAddress(String address) {
		this.address.setAddress(address);
	}
	
	/* 设置客户的年龄 */ 
	public String getCustomerAge() {
		return this.age.getAge();
	}
	
	public void setCustomerAge(String age) {
		this.age.setAge(age);
	}
}
