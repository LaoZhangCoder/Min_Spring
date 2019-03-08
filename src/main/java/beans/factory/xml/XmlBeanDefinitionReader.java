package beans.factory.xml;



import java.io.File;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


import beans.config.BeanDefinition;
import beans.factory.DefaultListableBeanFactory;
import beans.factory.support.BeanDefinitionRegistry;

public class XmlBeanDefinitionReader {
	private final BeanDefinitionRegistry registry;
	
	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super();
		this.registry = registry;
	}

	
	
	public BeanDefinitionRegistry getRegistry() {
		return registry;
	}



	
	 public void doLoadBeanDefinitions(File file)  {
	        // 在加載beandefinition之前，現getxml資源的Document對象
		 SAXReader builder = new SAXReader();
		 Document document;
		try {
			document = builder.read(file);
	       XmlParser.parser(document,(DefaultListableBeanFactory) registry);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 获得文档对象
	        // 在這裡講doc進行解析
 catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	   
	 }
}
