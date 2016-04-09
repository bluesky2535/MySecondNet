package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestHibernate {
	
     @Test
     public void sessionFactory(){
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
     }
}
