package club.xwzzy.interceptor.controller;

import club.xwzzy.interceptor.annotation.AuditLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 向往
 * @Date: 2020/06/11 23:32
 * @Description:
 */
@RestController
public class TestController {

     private Logger logger = LoggerFactory.getLogger(this.getClass());



    @GetMapping("/test1")
    @AuditLog(moduleName = "测试模块",logSwitch = false)
    public void test1()
    {
        System.out.println("test1 method");
    }



    @GetMapping("/test2")
    @AuditLog(moduleName = "测试模块",logSwitch = false)
    public void test2()
    {
        System.out.println("test1 method");
        throw new RuntimeException("error");
    }


}