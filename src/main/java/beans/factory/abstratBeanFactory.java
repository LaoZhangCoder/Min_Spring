package beans.factory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import beans.config.BeanDefinition;

public abstract class abstratBeanFactory  extends AbstractAutowireCapableBeanFactory{
	 protected Map<String, Object> singleBeanPool = new HashMap<String, Object>();
	    protected Map<String, Object> earlysingleBeanPool = new HashMap<String, Object>();
	    protected Map<String, Class<?>> BeanFactory = new HashMap<String, Class<?>>();
	   protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
	   private List<String> autowiredlist=new ArrayList<String>();


		public List<String> getAutowiredlist() {
		return autowiredlist;
	}

	public void setAutowiredlist(List<String> autowiredlist) {
		this.autowiredlist = autowiredlist;
	}

		public Map<String, Class<?>> getBeanFactory() {
			return BeanFactory;
		}

		public void setBeanFactory(Map<String, Class<?>> beanFactory) {
			BeanFactory = beanFactory;
		}

		public Map<String, Object> getEarlysingleBeanPool() {
			return earlysingleBeanPool;
		}

		public void setEarlysingleBeanPool(Map<String, Object> earlysingleBeanPool) {
			this.earlysingleBeanPool = earlysingleBeanPool;
		}

		public Map<String, Object> getSingleBeanPool() {
			return singleBeanPool;
		}

		public void setSingleBeanPool(Map<String, Object> singleBeanPool) {
			this.singleBeanPool = singleBeanPool;
		}
	    @SuppressWarnings("unchecked")
		public Object getsingleobject(String id) throws Exception{
	    	
	    	Object singletonObject=this.getSingleBeanPool().get(id);
	    	
	    
			return singletonObject;
	    	
	    }
	    protected void addsingle(Object object,String id) {    	
	    	this.getSingleBeanPool().put(id,object);	
	    	
	    		    	
	    }
	  protected <T> T  getbeanprototype(String id,BeanDefinition beanDefiniton) throws NoSuchMethodException, Exception {
		  Class<?> cl=null;
		  Object bean = null;
		  List<String> depends = beanDefiniton.getDepends();
		  if(beanDefiniton.getScope().equals("sigleton")) {			  
		    cl = BeanFactory.get(id);
			 bean = earlysingleBeanPool.get(id);
			 }else {
				cl = beanDefiniton.getBeanClass();
				bean=cl.newInstance();
			}
			if (depends != null) {
				for (String depend : depends) {
					// 对象依赖属性的注入
					resiterRef(cl, bean, beanDefiniton, depend);
				}
			}
			if(beanDefiniton.getProtpertymaps()!=null) {
			// 普通属性的注入
			resiterpropery(cl, bean, beanDefiniton);}

			return (T) bean;

		  
		  
		  
		  
	  }
	// 普通属性的依赖注入
		public void resiterpropery(Class<?> cl, Object bean, BeanDefinition beanDefinition) throws Exception {
			// 这里是普通属性的注入
			HashMap<String, String> map = beanDefinition.getMap();
			Set<Entry<String, String>> entrySet = map.entrySet();
			for (Entry<String, String> entry : entrySet) {
				populateBean(entry,cl, bean);
			}

		}
		

		

		// 对象属性的依赖注入
		public void resiterRef(Class<?> cl, Object bean, BeanDefinition beanDefinition, String depend)
				throws NoSuchMethodException, SecurityException, Exception {
				String key = beanDefinition.getRefname().get(depend);
					if(this.beanDefinitionMap.get(depend).getScope().equals("sigleton")) {
					String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
					// 获取bean的class对象
					// 通过反射获取方法
					Method method = cl.getMethod(methodName, this.getBeanFactory().get(depend));
					// 调用set方法完成注入
					method.invoke(bean, this.earlysingleBeanPool.get(depend));
				}
					if(this.beanDefinitionMap.get(depend).getScope().equals("prototype")) {
						String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
						// 获取bean的class对象
						// 通过反射获取方法
						 Class<?> beanClass = beanDefinitionMap.get(depend).getBeanClass();
						Method method = cl.getMethod(methodName,beanClass);
						Object newInstance = beanClass.newInstance();
						// 调用set方法完成注入
						method.invoke(bean,newInstance);
						if(beanDefinitionMap.get(depend).getProtpertymaps()!=null) {
							// 普通属性的注入
							resiterpropery(beanClass, newInstance, beanDefinitionMap.get(depend));}
						
					} 	
				}
			
		
		}

