package aop;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import Exception.BeansException;
import aop.JDKDynamicProxy.DoCglibDynamicProxy;
import aop.JDKDynamicProxy.JDKDynamicProxy;
import beans.factory.BeanFactoryAware;
import beans.factory.DefaultListableBeanFactory;
import beans.factory.xml.BeanFactory;

public abstract class AbstractAutoProxyCreator implements BeanFactoryAware {
	protected DefaultListableBeanFactory beanFactory;
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		this.beanFactory = (DefaultListableBeanFactory) beanFactory;
	}
	protected Object wrapIfNecessary(Object bean, String beanName) {
		HashMap<String,Class<?>> specificInterceptors = getAdvicesAndAdvisorsForBean(bean.getClass(), beanName);
		if (specificInterceptors!=null) {
			Object proxy = createProxy(bean.getClass(), beanName, specificInterceptors,bean);
			return proxy;
		}
		return bean;
	}
	
	private Object createProxy(Class<? extends Object> class1, String beanName,
			HashMap<String, Class<?>> specificInterceptors, Object bean) {
		// TODO Auto-generated method stub
		return this.beanFactory.getBeanDefinitionMap().get("aspectJAwareAdvisorAutoProxyCreator").getProxy_target_class().equals("true")?DoCglibDynamicProxy.docglibdynamicproxu(class1,specificInterceptors):Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), new JDKDynamicProxy(bean,specificInterceptors));

	}

	protected HashMap<String, Class<?>> getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName) {
		try {
			HashMap<String, Class<?>> advisors = findEligibleAdvisors(beanClass, beanName);
			return advisors;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	protected abstract HashMap<String, Class<?>> findEligibleAdvisors(Class<?> beanClass, String beanName) throws  Exception;

}
