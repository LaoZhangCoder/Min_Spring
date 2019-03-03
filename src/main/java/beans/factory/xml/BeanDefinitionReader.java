package beans.factory.xml;

import core.io.Resource;
import core.io.ResourceLoader;

public interface BeanDefinitionReader {

	ResourceLoader getResourceLoader();


	ClassLoader getBeanClassLoader();

	

	int loadBeanDefinitions(Resource resource);

	int loadBeanDefinitions(Resource... resources);

	int loadBeanDefinitions(String location);

	int loadBeanDefinitions(String... locations);
}
