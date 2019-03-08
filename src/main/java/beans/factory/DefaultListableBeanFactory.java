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
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
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
			// 只有单利的情况下才会处理循环依赖
			if (beanDefinition.getScope().equals("sigleton")) {
				if (isExitCiriu.contains(id)) {
					// 走进这里说明发生了循环依赖返回一个null
					return null;
				}
				isExitCiriu.add(id);
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
			}
		}
		return (T) object;
	}

	// 普通属性的依赖注入
	public void resiterpropery(Class<?> cl, Object bean, BeanDefinition beanDefinition) throws Exception {
		// 这里是普通属性的注入
		HashMap<String, String> map = beanDefinition.getMap();
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String value = entry.getValue();
			String key = entry.getKey();
			if (!(value.charAt(value.length() - 1) == '.')) {
				Method method = cl.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1),
						entry.getValue().getClass());
				method.invoke(bean, entry.getValue().toString());
			}
		}

	}

	// 对象属性的依赖注入
	public void resiterRef(Class<?> cl, Object bean, BeanDefinition beanDefinition, String depend)
			throws NoSuchMethodException, SecurityException, Exception {
		HashMap<String, String> protpertymaps = beanDefinition.getProtpertymaps();
		Set<Entry<String, String>> entrySet = protpertymaps.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (value.charAt(value.length() - 1) == '.') {
				String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
				// 获取bean的class对象
				// 通过反射获取方法

				Method method = cl.getMethod(methodName, this.getBeanFactory().get(depend));
				// 调用set方法完成注入

				method.invoke(bean, this.earlysingleBeanPool.get(depend));
			}
		}
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
