package beans.factory;

import Exception.BeansException;
import beans.factory.xml.BeanFactory;

public interface BeanFactoryAware {
	void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
