package gril.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAspect {
    private  final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * gril.demo.controller.GirlController.*(..))")
    public  void log(){
    }
    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
       ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("doAfter");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public  void doAfterReturning(Object object){
        if(object!=null) {
            logger.info("response={}", object.toString());
        }
    }
}
