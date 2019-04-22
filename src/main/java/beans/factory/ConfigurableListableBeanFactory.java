package beans.factory;

import java.util.List;

import beans.factory.xml.BeanFactory;

public interface ConfigurableListableBeanFactory extends BeanFactory{

	void ignoreDependencyType(Class<?> type);
	public <T> T Createbean(String id) throws Exception;
	void ignoreDependencyInterface(Class<?> ifc);
	List<String> getBeanNamesForType(Class<?> beanpost);
	
	void registerResolvableDependency(Class<?> dependencyType, Object autowiredValue);

}
