package _3advancedjavaprogrammingtechniques._5reflection._11exercisedynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class UdacisearchClientFactory {

    public static UdacisearchClient fromPropertyMap(Map<String, Object> properties) {
        Object proxy =
                Proxy.newProxyInstance(
                        UdacisearchClientFactory.class.getClassLoader(),
                        new Class<?>[]{UdacisearchClient.class},
                        new Handler(properties));
        return (UdacisearchClient) proxy;
    }

    private UdacisearchClientFactory() {
        // UdacisearchClientFactory cannot be instantiated.
    }

    private static final class Handler implements InvocationHandler {

        /*
         * In this example, the underlying object is a Map.
         * You could say that this dynamic proxy acts as an adapter
         * and the logging dynamic proxy acted as a decorator.
         */
        private final Map<String, Object> properties;

        private Handler(Map<String, Object> properties) {
            this.properties = new HashMap<>(Objects.requireNonNull(properties));
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // TODO: Fill this method in!
            String methodName = method.getName();
            String propertyName = getPropertyName(methodName);

            return this.properties.get(propertyName);
        }
    }

    private static String getPropertyName(String methodName) {
        if (methodName.length() <= 3 || !methodName.startsWith("get")) {
            return "";
        }
        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
    }
}