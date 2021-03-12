package org.chaos.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: AnimalProxy
 * @Description: TODO
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: rick-li@msyc.cc
 * @Date: 2021-03-05 16:51
 */
public class AnimalProxy implements InvocationHandler {

    private Object obj;

    public Object getProxy(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke");
        return invoke;
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        AnimalProxy proxy = new AnimalProxy();
        ((Animal) proxy.getProxy(dog)).hello();
    }
}
