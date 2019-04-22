package context.support;

import java.util.List;

import Handle.BeanPostProcessor;

import beans.factory.DefaultListableBeanFactory;

public class PostProcessorRegistrationDelegate {
	public static void registerBeanPostProcessors( DefaultListableBeanFactory beanFactory, AbstractApplicationContext applicationContext) {

		List<String> postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class);
        for (String string : postProcessorNames) {
			try {
				BeanPostProcessor createbean = (BeanPostProcessor)beanFactory.Createbean(string);
				List<BeanPostProcessor> list = beanFactory.getBeanPostProcessors();
				list.add(createbean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
