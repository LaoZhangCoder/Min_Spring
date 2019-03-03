package beans.factory.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import beans.config.BeanDefinition;



public class XmlParser {
	public static Map<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();
  
    public final static Map<String, BeanDefinition> parser(Document doc) {
		
		Element element = doc.getRootElement();// 获得根节点
		@SuppressWarnings("rawtypes")
		Iterator it = element.elementIterator();
		while (it.hasNext()) {
			Element node = (Element) it.next();
			//解析bean标签
			if(node.getName().equals("bean")) {
				BeanDefinition beanDefinition = new BeanDefinition();
				@SuppressWarnings("unchecked")
				List<Attribute> list = node.attributes();
				for (Attribute attr : list) {
                  if(attr.getName().equals("id")) {
                	  beanDefinition.setId(attr.getStringValue());
                  }else if(attr.getName().equals("name")) {
                	  beanDefinition.setName(attr.getStringValue());
                  }else if(attr.getName().equals("scope")) {
                	  beanDefinition.setScope(attr.getStringValue());
                  }else if(attr.getName().equals("class")){
                	 beanDefinition.setClasspath(attr.getStringValue());
                  }else {
                	  continue;
                  }
				
				}
				beanDefinitions.put(beanDefinition.getId(), beanDefinition);
				
			}
			
			
		}
		System.out.println(beanDefinitions);
		return beanDefinitions;
	
	    }
}

