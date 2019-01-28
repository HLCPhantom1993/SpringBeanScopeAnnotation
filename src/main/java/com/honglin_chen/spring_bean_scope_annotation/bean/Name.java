package com.honglin_chen.spring_bean_scope_annotation.bean;

import org.springframework.context.annotation.Scope; 
import org.springframework.stereotype.Component; 

/* 定义 Name bean 为一个 Singleton scope 的组件 */
@Scope(value="singleton")
@Component
public class Name {
	/* 定义实例变量 */ 
	private String firstName = "泓霖"; 
	private String lastName = "陈"; 
	
	/* Name bean 构造函数 */ 
	public Name() {
		System.out.println("创建新的名字: " + this.toString()); 
	}
	
	/* 定义getFirstName()函数返回名字 */ 
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName; 
	}
	
	/* 定义setFirstName()函数设置名字 */ 
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	
	/* 重载toString函数实现自定义的字符串儿编辑 */ 
	@Override 
	public String toString() {
		return this.getFirstName() + " " + this.getLastName(); 
	}
}
