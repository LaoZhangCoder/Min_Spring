package aop.JDKDynamicProxy;

import annotation.After;
import annotation.Around;
import annotation.Before;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CglibDynamicProxy implements MethodInterceptor {
    private HashMap<String, Class<?>> specificInterceptors;

    public CglibDynamicProxy(HashMap<String, Class<?>> specificInterceptors) {
        this.specificInterceptors = specificInterceptors;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        HashMap<String,Class<?>> hashMap = this.specificInterceptors;
        Class<?> value=null;
        Object o1=null;
        HashMap<String,Method> list = new HashMap<String,Method>();
        Set<Map.Entry<String,Class<?>>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, Class<?>> entry : entrySet) {
            value = entry.getValue();
            Method[] methods = value.getMethods();
            for (Method method2 : methods) {
                if(method2.isAnnotationPresent(Before.class)) {
                    method2.invoke(value.newInstance(),objects);
                    list.put("before",method2);
                }else if(method2.isAnnotationPresent(After.class)) {
                    list.put("after",method2);
                }else if(method2.isAnnotationPresent(Around.class)) {
                    list.put("around",method2);
                }
            }
           o1 = methodProxy.invokeSuper(o, objects);
            System.out.println("使用的是cglib代理");
            if(list.containsKey("after")) {
                Method method2 = list.get("after");
                method2.invoke(value.newInstance(), objects);
            }
        }
        return o1;
    }
}
