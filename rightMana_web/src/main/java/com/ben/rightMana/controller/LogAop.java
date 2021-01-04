package com.ben.rightMana.controller;

import com.ben.rightMana.domain.SysLog;
import com.ben.rightMana.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @AUTHOR Ben
 * @time 14:11
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LogService logService;

    // 访问开始时间
    private Date startTime;

    // 访问的是哪个类
    private Class clazz;

    // 访问那个方法
    private Method method;


    @Before("execution(* com.ben.rightMana.controller.*.*(..))")
    public void BeforeNote(JoinPoint jp) throws NoSuchMethodException {

        try {
            startTime = new Date();

            clazz = jp.getTarget().getClass();

            String methodName = jp.getSignature().getName();

            // 获取访问的方法的参数
            Object[] args = jp.getArgs();
            if (args == null || args.length == 0){
                method = clazz.getMethod(methodName);
            }else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classArgs[i] = args[i].getClass();
                }

                clazz.getMethod(methodName,classArgs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    @After("execution(* com.ben.rightMana.controller.*.*(..))")
    public void AfterNote(JoinPoint jp){

        try {
            // 获取最后的访问时长
            long sumTime = new Date().getTime() - startTime.getTime();

            // 获取访问的 URL
            String url = "";

            if (clazz != null && method != null && clazz != LogAop.class){

                // 首先获取类上的 @RequestMapping 中的值
                RequestMapping classAnnotation =(RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (classAnnotation != null){
                    String[] classValue = classAnnotation.value();

                    // 获取方法上的 @RequestMapping 中的值
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if (methodAnnotation != null){
                        String[] methodValue = methodAnnotation.value();

                        url = classValue[0] + methodValue[0];

                        // 获取访问的IP
                        String ip = request.getRemoteAddr();

                        // 获取当前操作者
                        /**
                         * 这里是通过 Spring Security 框架来获取当前应用的上下文
                         */
                        SecurityContext context = SecurityContextHolder.getContext();
                        User user =(User) context.getAuthentication().getPrincipal();   // 这里的这个 User 是 Security 框架中的 User
                        String username = user.getUsername();


                        // 将这些信息封装并保存
                        SysLog log = new SysLog();
                        log.setExecutionTime(sumTime);
                        log.setIp(ip);
                        log.setMethod("[类名]: " + clazz.getName() + "[方法名]: " + method.getName());
                        log.setUrl(url);
                        log.setUsername(username);
                        log.setVisitTime(startTime);

                        logService.saveLog(log);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
