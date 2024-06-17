package assignment1706.nhattruong.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurationProperties {
    String path() default  "";
}
