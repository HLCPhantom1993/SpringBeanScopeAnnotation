package com.honglin_chen.spring_bean_scope_annotation.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component; 

/* 将 Language Bean 定义为一个 Prototype Scope 的组件 */ 
/* Scope注解的代理模式可以将Language Bean注入到Singleton Bean的范围内 */
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Language {
	private String language = "中文"; 
	
	/* 语言类Bean构造函数 */ 
	public Language() {
		System.out.println("构造新的语言: " + this.language); 
	}
	
	/* getter 方法 */
	public String getLanguage() {
		return this.language; 
	}
	
	/* setter 方法 */ 
	public String setLanguage(String language) {
		this.language = language;
		return this.language; 
	}
}
