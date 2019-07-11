package com.ahuan.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCon implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取bean工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取环境属性
        Environment environment = conditionContext.getEnvironment();
        //获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")){
            return true;
        }
        return false;
    }
}
