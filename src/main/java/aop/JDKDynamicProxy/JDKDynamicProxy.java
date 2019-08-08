package aop.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import annotation.After;
import annotation.Around;
import annotation.Before;
import annotation.Pointcut;

import java.util.Set;

public class JDKDynamicProxy implements InvocationHandler{
	 private Object target;
	 private HashMap<String, Class<?>> specificInterceptors;

	    public JDKDynamicProxy(Object target) {
	        this.setTarget(target);
	    }

	
	public JDKDynamicProxy(Object bean, HashMap<String, Class<?>> specificInterceptors) {
			// TODO Auto-generated constructor stub
		this.setTarget(bean);
		this.specificInterceptors=specificInterceptors;
		
		}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		HashMap<String,Class<?>> hashMap = this.specificInterceptors;
		Class<?> value=null;
		HashMap<String,Method> list = new HashMap<String,Method>();
		Set<Entry<String,Class<?>>> entrySet = hashMap.entrySet();
		for (Entry<String, Class<?>> entry : entrySet) {
			 value = entry.getValue();
			Method[] methods = value.getMethods();
			for (Method method2 : methods) {
				if(method2.isAnnotationPresent(Before.class)) {
					method2.invoke(value.newInstance(),args);
					list.put("before",method2);
				}else if(method2.isAnnotationPresent(After.class)) {
					list.put("after",method2);
				}else if(method2.isAnnotationPresent(Around.class)) {
					list.put("around",method2);
				}
			}

			method.invoke(target, args);
			System.out.println("使用的是jdk动态代理代理");
			if(list.containsKey("after")) {
				Method method2 = list.get("after");
				method2.invoke(value.newInstance(), args);
			}
		}
		
		return null;
	}


	public Object getTarget() {
		return target;
	}


	public void setTarget(Object target) {
		this.target = target;
	}

}
