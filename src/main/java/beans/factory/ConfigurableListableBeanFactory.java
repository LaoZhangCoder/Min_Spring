package beans.factory;


public interface ConfigurableListableBeanFactory {

	void ignoreDependencyType(Class<?> type);

	void ignoreDependencyInterface(Class<?> ifc);

	
	void registerResolvableDependency(Class<?> dependencyType, Object autowiredValue);

}
