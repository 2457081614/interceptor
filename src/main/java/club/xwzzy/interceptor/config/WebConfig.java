package club.xwzzy.interceptor.config;

import club.xwzzy.interceptor.AuditLogInterceptor;
import club.xwzzy.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: 向往
 * @Date: 2020/06/11 23:22
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AuditLogInterceptor()).addPathPatterns("/**");

    }
}