package Test;

import Exception.ErrorElemetProtory;
import context.support.ClassPathXmlApplicationContext;
import core.io.ResourceLoader;

public class Testexception {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");
	 ErrorElemetProtory getbean = (ErrorElemetProtory)classPathXmlApplicationContext.getbean("tt");
		System.out.println(getbean);
	}
}
