package org;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserService us=new UserServiceImpl();
//        us.deleteUser();
//        us.registerUser();



        UserService proxy= (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(), us.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                System.out.println("权限校验");
                Object returnObject=method.invoke(us,args);
                System.out.println("日志记录");
                return returnObject;
            }
        });
//        System.out.println(proxy.getClass());
        proxy.registerUser();
        proxy.deleteUser();
    }
}

