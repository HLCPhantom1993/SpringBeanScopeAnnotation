package com.honglin_chen.spring_bean_scope_annotation.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component; 

/* 将Age类Bean设置为一个Session Scope的组件, 对每个HTTP请求的Session创建一个实例 */ 
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Age {
	private String age = "24"; 
	
	/* 年龄类Bean的构造函数 */ 
	public Age() {
		System.out.println("现在的年龄是: " + this.age); 
	}
	
	public String getAge() {
		return this.age; 
	}
	
	public void setAge(String age) {
		this.age = age; 
	}
 }
