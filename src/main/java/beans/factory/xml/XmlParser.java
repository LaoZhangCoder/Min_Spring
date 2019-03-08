package beans.factory.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import Enums.Scope;
import beans.config.BeanDefinition;
import beans.factory.DefaultListableBeanFactory;
public class XmlParser {
	public static Map<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();
    @SuppressWarnings("unlikely-arg-type")
	public final static Map<String, BeanDefinition> parser(Document doc, DefaultListableBeanFactory registry) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		beanDefinitions=registry.getBeanDefinitionMap();
		Element element = doc.getRootElement();// 获得根节点
		@SuppressWarnings("rawtypes")
		Iterator it = element.elementIterator();
		while (it.hasNext()) {
			Element node = (Element) it.next();
			//解析bean标签
			if(node.getName().equals("bean")) {
				BeanDefinition beanDefinition = new BeanDefinition();
				Iterator elementIterator = node.elementIterator();
				@SuppressWarnings("unchecked")
				List<Attribute> list = node.attributes();
				while(elementIterator.hasNext()) {
					Element next = (Element)elementIterator.next();
					if(next.getName().equals("property")) {
					List<Attribute> attributes = next.attributes();
					String str="";
				for (Attribute attribute : attributes) {
					if(attribute.getName().equals("name")) {
						str=attribute.getStringValue();
						beanDefinition.getMap().put(str, attribute.getStringValue());
					}
					if(attribute.getName().equals("value"))
							{
						beanDefinition.getMap().put(str, attribute.getStringValue());
					}
					if(attribute.getName().equals("ref")) {
						beanDefinition.getDepends().add(attribute.getValue());
						beanDefinition.getMap().put(str, attribute.getStringValue()+".");
						
					}
				}
				}
				}
				
				
				
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
			//这里后面我会加一个条件只要在单例的情况下我才会创建其工厂防止其循环依赖
				if(beanDefinition.getScope().equals("sigleton")) {
					System.out.println("456");
		registry.getBeanFactory().put(beanDefinition.getId(), beanDefinition.getBeanClass());}
				beanDefinitions.put(beanDefinition.getId(), beanDefinition);
				
			}
			
			
		}
		System.out.println(beanDefinitions);
		return beanDefinitions;
	
	    }
}

