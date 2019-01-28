package com.honglin_chen.spring_bean_scope_annotation.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/* 将Address类Bean声明为一个Request Scope的组件, 它的代理模式会将
 * 当前short-lived的bean注入到long-lived的bean实例中, 每次的HTTP
 * 请求都会为该类创建一个实例
 */
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Address {
	private String address = "美国🇺🇸"; 
	
	/* 地址类Bean的构造函数 */ 
	public Address() {
		System.out.println("现在的地址是: " + this.address); 
	}
	
	/* 得到地址 */ 
	public String getAddress() {
		return this.address; 
	}
	
	/* 设置地址 */ 
	public void setAddress(String address) {
		this.address = address; 
	}
}
