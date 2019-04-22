package aop;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import Exception.BeansException;
import Handle.BeanPostProcessor;
import annotation.AspectJ;
import annotation.Pointcut;
import beans.config.BeanDefinition;
import beans.factory.DefaultListableBeanFactory;
import beans.factory.xml.BeanFactory;

public class AspectJAwareAdvisorAutoProxyCreator<E> extends AbstractAutoProxyCreator implements BeanPostProcessor {
    protected DefaultListableBeanFactory beanFactory; 
    protected HashSet<String> poincutlist=new HashSet<String>();
    protected HashMap<String,Class<?>> aspectlist=new HashMap<String,Class<?>>();
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return wrapIfNecessary(bean,beanName);
	
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		this.beanFactory=(DefaultListableBeanFactory) beanFactory;
	}

	@Override
	protected HashMap<String,Class<?>> findEligibleAdvisors(Class<?> beanClass, String beanName) throws  Exception {
		// TODO Auto-generated method stub
		Map<String, BeanDefinition> beanDefinitionMap = this.beanFactory.getBeanDefinitionMap();
		HashMap<String,Class<?>> list=null;
		Set<Entry<String,BeanDefinition>> entrySet = beanDefinitionMap.entrySet();
		if(beanClass.isAnnotationPresent(AspectJ.class)) {
		for (Entry<String, BeanDefinition> entry : entrySet) {
			String classpath = entry.getValue().getClasspath();
			Class<?> forName = Class.forName(classpath);
			if(forName.isAnnotationPresent(AspectJ.class)){
				aspectlist.put(forName.toString(),forName);
			
				Method[] methods = forName.getDeclaredMethods();
				if(methods!=null) {
					for (Method method : methods) {					
						if(method.isAnnotationPresent(Pointcut.class)) {
							Pointcut pc=method.getAnnotation(Pointcut.class);
							poincutlist.add(pc.execution());
						}
						
					}
				}
			}	
		}
		}else {
	
		list = IFistarget(beanClass,beanName);
		}
		
		return list;
	}

	private HashMap<String,Class<?>> IFistarget(Class<?> beanClass, String beanName) {
		// TODO Auto-generated method stub
		Method[] declaredMethods = beanClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
		if(poincutlist.contains(method.getName()+"()")) {
			
			return aspectlist;
			
		}
		}
		return null;
		
	}
	

}
