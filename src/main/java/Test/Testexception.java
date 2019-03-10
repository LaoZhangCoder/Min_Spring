package Test;
import context.support.ClassPathXmlApplicationContext;
import untils.PackageUtil;
public class Testexception {
	private static final String Testb = null;

	public static void main(String[] args) {
		
	
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");        
         PackageUtil getbean2 =(PackageUtil)context.getbean("PackageUtil");
        getbean2.aaa();

	}
	
}
