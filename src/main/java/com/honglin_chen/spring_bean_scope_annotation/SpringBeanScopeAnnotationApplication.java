package com.honglin_chen.spring_bean_scope_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBeanScopeAnnotationApplication {

	public static void main(String[] args) {
		/**
		 * 主程序运行时将只会载入范围为Singleton的Bean, 因为Singleton的Bean被设置
		 * 为默认范围, 所有程序启动时会加载Name构造函数, 为其初始化实例变量
		 * 
		 * 我们通过端口向8080/name服务端发送一个重置客户名字的请求: 
		 * http://localhost:8080/name: name url数据请求将会更改用户的名字
		 * 
		 * 我们通过namecheck url地址检测服务器端口现在客户的名字
		 * http://localhost:8080/namecheck 
		 * 
		 * 语言类Bean的范围定义为Prototype所以其构造函数为其实例初始化时会赋值它的原型
		 * 数值, 即“中文", 也就是说this关键字指向的永远是语言bean的原型. 每次使用原型
		 * 范围类的函数时都会指向其原型, 构造一个原型实例. 所以我们再检测原型语言时返回
		 * 的还是"中文"而不是“日文”. 即每次使用this.language时language对象都是指向
		 * 原型的. 
		 * 
		 */
		SpringApplication.run(SpringBeanScopeAnnotationApplication.class, args);
	}

}

