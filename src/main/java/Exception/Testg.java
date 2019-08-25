package Exception;

import annotation.Component;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Component
public class Testg {
    public static void main(String ss[]) {
        test();
    }
    static void test() {
        while (true) {
            Enhancer e = new Enhancer();
            e.setSuperclass(OOMObject.class);//要生成<span style="font-family:微软雅黑;font-size:14px;">OOMObject类的子类</span>
            e.setUseCache(false);
            e.setCallback(new MethodInterceptor() {//设置callback，对原有对象的调用全部转为调用<span style="font-family:微软雅黑;font-size:14px;">MethodInterceptor的intercept方法</span>

                public Object intercept(Object obj, Method method,
                                        Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("Before invoke ");
                    Object result = proxy.invokeSuper(obj, args);
                    System.out.println("After invoke");
                    return result;
                }
            });
            OOMObject ee = (OOMObject) e.create();
            ee.test();
        }
    }

    static class OOMObject {
        public void test() {
            System.out.println("invokinginginginging....");
        }

    }
}
