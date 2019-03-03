package Test;

import context.support.ClassPathXmlApplicationContext;
import core.io.DefaultResourceLoader;
import core.io.ResourceLoader;

public class Testexception {
	public static void main(String[] args) {
		 ResourceLoader loader = new DefaultResourceLoader();  
		 loader.getResource("C:\\自学第一次\\min_spring\\src\\main\\resources");
		
	}
}
