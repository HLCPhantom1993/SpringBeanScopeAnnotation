package com.honglin_chen.spring_bean_scope_annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglin_chen.spring_bean_scope_annotation.bean.Customer;

/* 定义网络控制器提供处理数据请求 */
@RestController
public class WebController {
	@Autowired
	private Customer customer;
	
	/* 请求映射标签, 如果请求数据映射到url地址: “/name”则执行被“/name“请求映射标记的函数 */
	@RequestMapping("/name") 
	public String name() {
		/* http://localhost:8080/name */
		String res = customer.getCustomerName(); 
		customer.setCustomerName("Micheal", "Chen");
		return "初始数据: " + res + "-----------" + "更改数据: " + customer.getCustomerName();
	}
	
	@RequestMapping("/namecheck")
	public String namecheck() {
		/* Singleton实例对象只会存在1个, 即只会call它的构造函数1次 */ 
		return "检测数据: " + customer.getCustomerName(); 
	}
	
	@RequestMapping("/language")
	public String language() {
		String res = customer.getCustomerLanguage(); 
		/* customer.setCustomerLanguage("日语"); 会生成新的实例因为Language Bean
		 * 被定义为Prototype范围, 每次我们reference它都会生成新的实例
		 */
		/* newLanguage的原型语言依旧为“中文" */
		String newLanguage = customer.setCustomerLanguage("日文"); 
		return "初始语言数据: " + res + "-----------" + "更改数据: " + newLanguage;
	}
	
	@RequestMapping("/languagecheck")
	public String languagecheck() {
		/* 当我们检测语言时, customer的得到客户语言方法使用了language对象, 每次使用该对象
		 * 时即生成一个新的对象实例指向其原型语言"中文". 
		 */
		return "检测数据: " + customer.getCustomerLanguage(); 
	}
	
	@RequestMapping("/address")
	public String address() {
		/* 每次的HTTP数据请求都会为Address Bean 创建一个实例, 即每次在地址栏刷新请求url, 
		 * 地址构造函数都会被call, 返回的是原型数据, 与原型范围类似 
		 */
		String res = customer.getCustomerAddress();
		customer.setCustomerAddress("日本大阪");
		return "初始地址数据: " + res + "-----------" + "更改数据: " + customer.getCustomerAddress();
	}
	
	@RequestMapping("/addresscheck")
	public String addresscheck() {
		/* 当使用address实例变量call内部函数时, 与原型范围类似先通过构造函数创建一个实例, 
		 * 然后返回其原型数据
		 */
		return "检测数据: " + customer.getCustomerAddress();
	}
	
	@RequestMapping("/age") 
	public String age() {
		/* session cookie 会记录更改后的数据, 当timeout结束时更改后的记录就会消失 */
		/* 每次发送请求会创建一个新的年龄实例 */ 
		String res = customer.getCustomerAge(); 
		customer.setCustomerAge("20");
		return "初始年龄数据: " + res + "-----------" + "更改数据: " + customer.getCustomerAge();
	}
	
	@RequestMapping("agecheck")
	public String agecheck() {
		/* 10秒之后session会被清空, 再次发送请求会得到最初的数据, 但是会创建一个新的
		 * 年龄实例, 即call年龄的构造函数
		 */
		return "检测数据: " + customer.getCustomerAge(); 
	}
	
	/* server.servlet.session.cookie.max-age = 10
	 * server.servlet.session.timeout = 10 将服务器的session计时器设定为10秒
	 */
}
