package com.nick.love.myra;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class MyraListener implements ServletContextListener {
   @Override 
   public void contextDestroyed(ServletContextEvent contextEvent) {
	   System.out.println(getClass().getName() + ".contextDestroyed");
	   System.out.println("I love Myra Ma.");
   }
   
   @Override 
   public void contextInitialized(ServletContextEvent contextEvent) {
	   System.out.println(getClass().getName() + ".contextInitialized");
	   System.out.println("Nick's Girl : Myra Ma.");
   }
}
