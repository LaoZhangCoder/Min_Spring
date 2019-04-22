package aop;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import aop.JDKDynamicProxy.JDKDynamicProxy;
import beans.factory.BeanFactoryAware;
public abstract class AbstractAutoProxyCreator implements BeanFactoryAware {
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
		 return Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), new JDKDynamicProxy(bean));
		
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
