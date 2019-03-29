package Test;
import Exception.Testc;
import context.support.ClassPathXmlApplicationContext;
public class Testexception {
	private static final String Testb = null;

	public static void main(String[] args) {
		
	
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");        
       
        Testc c=(Testc)context.getbean("bbb");
   
    System.out.println(c.getTesta().getBooleana());
    System.out.println(c.getTesta().getInta());
    System.out.println(c.getTestc());

	}
	
}
