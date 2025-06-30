package approximations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {METHOD, TYPE})
public @interface Test {
    int executionMax() default 0;

    boolean disabled() default false;

    String reason() default "";
}
