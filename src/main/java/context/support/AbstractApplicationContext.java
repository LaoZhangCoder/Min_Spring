package context.support;


import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.DefaultListableBeanFactory;

public abstract class AbstractApplicationContext extends AutowiredApplication implements Application{
	private final Object startupShutdownMonitor = new Object();


	protected abstract void refreshBeanFactory();
	public void refresh() {
		synchronized (this.startupShutdownMonitor) {
		
		ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
		//注册bean的处理器
		registerBeanPostProcessors(beanFactory);
	}
	}
	protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		PostProcessorRegistrationDelegate.registerBeanPostProcessors((DefaultListableBeanFactory) beanFactory, this);
	}
	
		protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
			refreshBeanFactory();
			ConfigurableListableBeanFactory beanFactory = getBeanFactory();
			
			return beanFactory;
		}
	
		public abstract ConfigurableListableBeanFactory getBeanFactory();
	}