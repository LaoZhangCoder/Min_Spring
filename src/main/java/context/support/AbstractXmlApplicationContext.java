package context.support;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Exception.BeansException;
import beans.config.BeanDefinition;
import beans.factory.support.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import beans.factory.xml.XmlParser;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext {
	
	private final Object startupShutdownMonitor = new Object();
	public void refresh() {
		synchronized (this.startupShutdownMonitor) {
		
			XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
			loadBeanDefinitions(reader);
			

	}
	}
	
	protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) {
		
		String configLocations = getConfigpath();
		if (configLocations != null) {
			reader.loadBeanDefinitions(configLocations);
		}
	}
	@SuppressWarnings("unchecked")
	protected <T> T  dogetbean(String id) throws Exception{
		Object object=null;
		if(id==null) {
			throw new BeansException("请输入bean的id");
		}else {
		Map<String, BeanDefinition> beanDefinitions = XmlParser.beanDefinitions;
		if(beanDefinitions.containsKey(id)) {
			BeanDefinition beanDefinition = beanDefinitions.get(id);
			String classpath = beanDefinition.getClasspath();
			Class<?> newInstance1= Class.forName(classpath);
			 object = newInstance1.newInstance();
		System.out.println(object);
			HashMap<String,String> map = beanDefinition.getMap();
			Set<Entry<String,String>> entrySet = map.entrySet();
			for (Entry<String, String> entry : entrySet) {
				String key = entry.getKey();
				 Method method = newInstance1.getMethod("set"+key.substring(0, 1).toUpperCase()+key.substring(1),entry.getValue().getClass());
		            method.invoke(object,entry.getValue().toString());
				
				
				 System.out.println(object);
			
			}
			
		}else {
			throw new BeansException("不存在bean请检查其id输入是否正确和是否配置了id!");
		}
       		
		}
		
		return (T) object;
		
		
		
		
		
		
	}
}
