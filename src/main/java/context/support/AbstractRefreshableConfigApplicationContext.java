package context.support;
import Exception.BeansException;
import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.DefaultListableBeanFactory;

public abstract class AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext {
	//这里就将旧版本的beanfactory通过组合模式组装进来了
	private DefaultListableBeanFactory beanFactory;

	
	private final Object beanFactoryMonitor = new Object();

	@Override
	protected void refreshBeanFactory() {
		// TODO Auto-generated method stub
				DefaultListableBeanFactory beanFactory = createBeanFactory();
		loadBeanDefinitions(beanFactory);
		
		//这里作用是检查是否开启了注解自动注入即@autowired等注解
				try {
					CreatebeanbyAutowired(beanFactory);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		synchronized (this.beanFactoryMonitor) {
			this.beanFactory = beanFactory;
		}
	}

	public DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory();
	}
	protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

	@Override
	public final ConfigurableListableBeanFactory getBeanFactory() {
		synchronized (this.beanFactoryMonitor) {
			if (this.beanFactory == null) {
				throw new IllegalStateException("BeanFactory not initialized or already closed - " +
						"call 'refresh' before accessing beans via the ApplicationContext");
			}
			return this.beanFactory;
		}
	}

	public <T> T getbean(String id) {
		// TODO Auto-generated method stub
		try {
			return dogetbean(id,this.beanFactory);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	private <T> T dogetbean(String id, DefaultListableBeanFactory beanFactory2) throws Exception {
		Object object=null;
		if(id==null) {
			throw new BeansException("请输入bean的id");
		}else {
			return beanFactory2.Createbean(id);
	
		}
	
	
}
}
