package Test;
import Exception.Testb;
import Exception.Testc;
import context.support.ClassPathXmlApplicationContext;
public class Testexception {
	private static final String Testb = null;

	public static void main(String[] args) {
		
	
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
         
         
           Testc getbeanbc = (Testc)context.getbean("cc");
           System.out.println(getbeanbc);
           Testb getbean = context.getbean("bb");
         System.out.println(getbean.getTestc());

	}
	
}
