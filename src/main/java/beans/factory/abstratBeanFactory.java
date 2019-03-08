package beans.factory;

import java.util.HashMap;
import java.util.Map;

public abstract class abstratBeanFactory {
	 protected Map<String, Object> singleBeanPool = new HashMap<String, Object>();
	    protected Map<String, Object> earlysingleBeanPool = new HashMap<String, Object>();
	    protected Map<String, Class<?>> BeanFactory = new HashMap<String, Class<?>>();
	    

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
}
