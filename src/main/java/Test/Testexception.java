package Test;
import Exception.Testc;
import Exception.Teste;
import Exception.testaa;
import context.support.ClassPathXmlApplicationContext;
public class Testexception {
	private static final String Testb = null;

	public static void main(String[] args) {
		
	
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");        
       context.getbean("testd");
testaa getbean = (testaa)context.getbean("teste");
getbean.test();


	}
	
}
