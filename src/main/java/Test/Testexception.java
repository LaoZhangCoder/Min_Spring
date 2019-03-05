package Test;

import Exception.BeansException;
import context.support.ClassPathXmlApplicationContext;

public class Testexception {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");
		BeansException getbean = (BeansException)classPathXmlApplicationContext.getbean("tt");
	System.out.println(getbean.getRead());
	System.out.println(getbean.getRead1());
	System.out.println(getbean.getRead2());
	}
}
