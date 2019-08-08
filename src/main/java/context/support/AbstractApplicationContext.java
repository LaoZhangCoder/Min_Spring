package context.support;


import java.util.ArrayList;
import java.util.List;

import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.DefaultListableBeanFactory;

public abstract class AbstractApplicationContext extends AutowiredApplication implements Application {
    private final Object startupShutdownMonitor = new Object();


    protected abstract void refreshBeanFactory();

    public void refresh() {
        synchronized (this.startupShutdownMonitor) {

            ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
            //注册bean的处理器
            registerBeanPostProcessors(beanFactory);
            //初始化lazy-init为false的标签
            finishBeanFactoryInitialization(beanFactory);
        }
    }

    private void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
        // TODO Auto-generated method stub
        List<String> list = getBeanNamesList();
        for (String string : list) {
            getbean(string);
        }

    }

    private List<String> getBeanNamesList() {
        // TODO Auto-generated method stub
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) this.getBeanFactory();
        List<String> list = beanFactory.getBeanNamesList();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : list) {
            if (!beanFactory.getBeanDefinitionMap().get(string).getLazy_init()) {
                arrayList.add(string);
            }
        }
        System.out.println("不延迟初始化的bean有" + list.toString());
        return arrayList;
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