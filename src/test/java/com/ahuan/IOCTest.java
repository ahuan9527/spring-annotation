package com.ahuan;

import com.ahuan.beans.Person;
import com.ahuan.config.PersonConfig;
import com.ahuan.config.ScopeTest;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeTest.class);
    @Test
    public void Test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames
             ) {
            System.out.println(name);
        }

    }
    @Test
   public void  test02(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeTest.class);
       /* String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames
        ) {
            System.out.println(name);
        }*/
        System.out.println("ico 创建");
        Person person = (Person) context.getBean("person");

        Person person1 = (Person) context.getBean("person");
        System.out.println(person == person1);
    }
    @Test
    public void test03(){
        System.out.println("测试conditional");

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
        //获取环境变量
//        ConfigurableEnvironment environment = context.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType
             ) {
            System.out.println(name);
        }
    }
}
