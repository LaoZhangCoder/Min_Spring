package context.support;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import Exception.BeansException;
import beans.config.BeanDefinition;
import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import beans.factory.xml.XmlParser;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext {
	
	private final Object startupShutdownMonitor = new Object();
	private File file;
	
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	
			
		
		
		
		
	
	@Override
		protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
			
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		loadBeanDefinitions(beanDefinitionReader);
			
		}
	protected void loadBeanDefinitions(XmlBeanDefinitionReader reader)  {
		File file= getFile();
		if (file!= null) {
			reader.doLoadBeanDefinitions(file);
		}
		
	}
	}
