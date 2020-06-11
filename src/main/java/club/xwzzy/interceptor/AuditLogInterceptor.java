package club.xwzzy.interceptor;

import club.xwzzy.interceptor.annotation.AuditLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: 向往
 * @Date: 2020/06/11 23:25
 * @Description:
 */

public class AuditLogInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(AuditLogInterceptor.class);

    /**
     * 在实际的Handle执行前执行；有Boolean类型的返回值，如果返回为False，
     * 则Handle本身及postHandle/afterCompletion以及后续的拦截器全部都不会再继续执行；
     * 为True则反之。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle--request{},response{},handle{}", request.toString(), response.toString(), handler.toString());
        if (handler instanceof HandlerMethod) {
            //获取注解
            AuditLog auditLog = ((HandlerMethod) handler).getMethod().getAnnotation(AuditLog.class);
            if (auditLog != null && auditLog.logSwitch()) {
                // 执行我们的业务逻辑
                // 获取业务名称
                logger.info("module name is {}", auditLog.moduleName());

            }

        }
        return super.preHandle(request, response, handler);
    }

    /**
     * Handle执行后视图渲染前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle--");
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * Handle执行且视图渲染完成后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion--");
        // 记录操作结果
        // 有异常说明操作失败
        if(ex != null) {

        }
        super.afterCompletion(request, response, handler, ex);



    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("afterConcurrentHandlingStarted--");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}