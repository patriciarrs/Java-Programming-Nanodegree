package _3advancedjavaprogrammingtechniques._5reflection._5definingcustomannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* Runtime retention policy is chosen because the testing framework needs to use reflection to see the annotations at runtime. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}
