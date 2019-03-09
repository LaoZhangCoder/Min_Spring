package beans.factory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import beans.config.BeanDefinition;
import beans.factory.support.BeanDefinitionRegistry;

public class DefaultListableBeanFactory extends abstratBeanFactory
		implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {
	
	// 创建完成bean池，我会将创建已完成的bean放入其中
	protected HashSet<String> isExitCiriu = new HashSet<String>();

	public Map<String, BeanDefinition> getBeanDefinitionMap() {
		return beanDefinitionMap;
	}

	@SuppressWarnings("unchecked")
	public <T> T Createbean(String id) throws Exception {
		Object object = null;
		Map<String, BeanDefinition> beanDefinitions = getBeanDefinitionMap();
		if (!beanDefinitions.containsKey(id)) {
			new RuntimeException("不存在id为" + id + "的bean");
		}
		BeanDefinition beanDefinition = beanDefinitions.get(id);
		Object object1 = this.getsingleobject(id);
		if (object1 != null) {
			object = object1;
		} else {
			if (isExitCiriu.contains(id)) {
				// 走进这里说明发生了循环依赖返回一个null
				return null;
			}
			isExitCiriu.add(id);
			// 只有单利的情况下才会处理循环依赖
			if (beanDefinition.getScope().equals("sigleton")) {
			
				// 解决循环依赖,提前曝光对象
				if (!earlysingleBeanPool.containsKey(id)) {
					earlysingleBeanPool.put(id, BeanFactory.get(id).newInstance());
				}

				List<String> list = beanDefinitions.get(id).getDepends();
				if (list != null) {
					for (String string : list) {
						Createbean(string);
					}
				}
				object = getbeansingle(id, beanDefinition);
				addsingle(object,id);
				isExitCiriu.remove(id);
			}else if(beanDefinition.getScope().equals("prototype")) {
				
				List<String> list = beanDefinitions.get(id).getDepends();
				if (list != null) {
					for (String string : list) {
						Createbean(string);
					}
				}
			object= getbeanprototype(id, beanDefinition);
			isExitCiriu.remove(id);
				
			}
		}
		return (T) object;
	}

	

	public <T> T getbeansingle(String id, BeanDefinition beanDefinition) throws Exception {
		List<String> depends = beanDefinition.getDepends();
		Class<?> cl = BeanFactory.get(id);
		Object bean = null;
		bean = earlysingleBeanPool.get(id);
		if (depends != null) {
			for (String depend : depends) {
				// 对象依赖属性的注入
				resiterRef(cl, bean, beanDefinition, depend);
			}
		}
		// 普通属性的注入
		resiterpropery(cl, bean, beanDefinition);

		return (T) bean;

	}
	public void ignoreDependencyType(Class<?> type) {
		// TODO Auto-generated method stub

	}

	public void ignoreDependencyInterface(Class<?> ifc) {
		// TODO Auto-generated method stub

	}

	public void registerResolvableDependency(Class<?> dependencyType, Object autowiredValue) {
		// TODO Auto-generated method stub

	}

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		// TODO Auto-generated method stub

	}

	public void removeBeanDefinition(String beanName) {
		// TODO Auto-generated method stub

	}

	public BeanDefinition getBeanDefinition(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean containsBeanDefinition(String beanName) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getBeanDefinitionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getBeanDefinitionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBeanNameInUse(String beanName) {
		// TODO Auto-generated method stub
		return false;
	}

}
