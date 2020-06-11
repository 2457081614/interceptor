package club.xwzzy.interceptor.annotation;

import java.lang.annotation.*;

/**
 * @author Administrator
 * @Auther: 向往
 * @Date: 2020/06/11 23:39
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AuditLog {

    String moduleName() default  "";

    boolean logSwitch() default true;
}