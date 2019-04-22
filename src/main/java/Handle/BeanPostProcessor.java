package Handle;

import Exception.BeansException;

public interface BeanPostProcessor {
    //前置处理器
	Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

	//后置处理器
	Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}



