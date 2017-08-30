package com.wudi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy implements InvocationHandler{
    
    private Object target = null; //保存真实业务对象
    
    /**
     * 返回动态代理类的对象,这样用户才可以利用代理类对象去操作真实对象
     * @description 
     * @param obj 包含有真实业务实现的对象
     * @return 返回代理对象
     */
    public Object getProxy(Object obj){
        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader()
                , obj.getClass().getInterfaces(), this);
    }
    
    public void open(){
        System.out.println("1:open datasource");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);//通过反射调用真实业务对象的业务方法,并且返回
        return result;
    }
    
    public void close(){
        System.out.println("3:close datasource");
    }

}