package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {
	
	private ApplicationContext  ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void myTest() {
        
		System.out.println(ac.getBean("sessionFactory"));
	
	}
}
