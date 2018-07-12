package com.cloud.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/***
 *  @Author dengwei
 *  @Description: TODO
 *  @Date 2018/7/12 15:01
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static  <T> T getBean(String className,Class<T> tClass){
        return applicationContext.getBean(className,tClass);
    }
}
