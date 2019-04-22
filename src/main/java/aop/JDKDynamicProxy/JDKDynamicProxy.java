package aop.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKDynamicProxy implements InvocationHandler{
	 private Object target;

	    public JDKDynamicProxy(Object target) {
	        this.target = target;
	    }

	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(111);
		System.out.println(proxy.getClass());
		System.out.println(method);
		System.out.println(args.toString());
		return null;
	}

}
