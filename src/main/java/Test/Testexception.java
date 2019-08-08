package Test;
import Exception.testaa;
import context.support.ClassPathXmlApplicationContext;

public class Testexception {
	
	public static void main(String[] args) {
 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
 testaa teste = (testaa)context.getbean("aa");
teste.test();


	}
	
}
