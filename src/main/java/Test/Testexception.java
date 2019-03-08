package Test;
import Exception.Testa;
import Exception.Testc;
import context.support.ClassPathXmlApplicationContext;
public class Testexception {
	public static void main(String[] args) {
		
	
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
         
           Testc getbeanc = (Testc)context.getbean("cc");
       
         System.out.println(getbeanc.toString());
        
      
       
	 
	}
	
}
