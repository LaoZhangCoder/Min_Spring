package beans.factory.xml;



import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import beans.factory.support.DefaultListableBeanFactory;

public class XmlBeanDefinitionReader {

	public XmlBeanDefinitionReader() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadBeanDefinitions(String location)  {
		
		
		doLoadBeanDefinitions(location);
		
	}
	 public void doLoadBeanDefinitions(String resource)  {
	        // 在加載beandefinition之前，現getxml資源的Document對象
		 
		 SAXReader builder = new SAXReader();
		 Document document;
		try {
			document = builder.read(new File(resource));
			 XmlParser.parser(document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 获得文档对象
	        // 在這裡講doc進行解析
	   
	 }
}
