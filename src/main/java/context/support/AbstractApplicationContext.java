package context.support;

import beans.factory.ConfigurableListableBeanFactory;

public abstract class AbstractApplicationContext extends AutowiredApplication implements Application{
	private final Object startupShutdownMonitor = new Object();


	protected abstract void refreshBeanFactory();
	public void refresh() {
		synchronized (this.startupShutdownMonitor) {
		
		ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

	}
	}
		protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
			refreshBeanFactory();
			ConfigurableListableBeanFactory beanFactory = getBeanFactory();
			
			return beanFactory;
		}
	
		public abstract ConfigurableListableBeanFactory getBeanFactory();
	}