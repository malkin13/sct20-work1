package lesson08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvolker  implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        OwnerLoader ownerLoader = new OwnerLoader(proxy
                .getClass().getClassLoader());

        Class ownerClass = ownerLoader.loadClass("OwnerImpl");

        Method newMethod = ownerClass.getMethod(method.getName());

        return newMethod.invoke(ownerClass.newInstance(), args);
    }
}
