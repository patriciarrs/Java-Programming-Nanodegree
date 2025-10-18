package _3advancedjavaprogrammingtechniques._5reflection._10dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

// A dynamic proxy is a class that implements a list of interfaces specified at runtime.
public final class LoggingProxy {
    public static void main(String[] args) {

        Set<String> targetSet = new HashSet<>();

        // 2. Create a dynamic proxy instance using the Proxy.newProxyInstance().
        Object proxy = Proxy.newProxyInstance(
                LoggingProxy.class.getClassLoader(),
                new Class[]{Set.class},
                new LoggingInvocationHandler(targetSet));

        Set<String> loggedSet = (Set<String>) proxy;
        /*
         * When clients call a method on the proxy instance,
         * the method invocation is forwarded to MethodInvocationHandler.
         */
        loggedSet.add("item");

        System.out.println(targetSet.contains("item"));
    }

    /*
     * 1. Create a custom InvocationHandler.
     * InvocationHandler is an abstract class that receives method invocations.
     * A method invocation is a Method and an array of parameters.
     */
    static class LoggingInvocationHandler implements InvocationHandler {

        private final Object targetObject;

        public LoggingInvocationHandler(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(targetObject.getClass() + "." + method.getName() + "()");
            return method.invoke(targetObject, args);
        }
    }
}