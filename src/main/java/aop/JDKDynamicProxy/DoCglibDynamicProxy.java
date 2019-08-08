package aop.JDKDynamicProxy;

import org.springframework.cglib.proxy.Enhancer;

import java.util.HashMap;

public class DoCglibDynamicProxy {

    public static Object docglibdynamicproxu(Class<? extends Object> class1,HashMap<String, Class<?>> specificInterceptors){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(class1);
        enhancer.setCallback(new CglibDynamicProxy(specificInterceptors));
          return enhancer.create();

    }
}
