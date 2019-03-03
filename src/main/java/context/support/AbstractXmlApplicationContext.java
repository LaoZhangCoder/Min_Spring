package context.support;

import java.io.IOException;
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
	protected <T> T  dogetbean(String id) throws Exception{
		Object newInstance=null;
		if(id==null) {
			throw new BeansException("请输入bean的id");
		}else {
		Map<String, BeanDefinition> beanDefinitions = XmlParser.beanDefinitions;
		if(beanDefinitions.containsKey(id)) {
			BeanDefinition beanDefinition = beanDefinitions.get(id);
			String classpath = beanDefinition.getClasspath();
			Class<?> forName = Class.forName(classpath);
			newInstance = forName.newInstance();
		}else {
			throw new BeansException("不存在bean请检查其id输入是否正确和是否配置了id!");
		}
       		
		}
		return (T) newInstance;
		
		
		
		
		
		
	}
}
