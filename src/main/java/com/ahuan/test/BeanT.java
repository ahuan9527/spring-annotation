package com.ahuan.test;

import com.ahuan.beans.Person;
import com.ahuan.config.PersonConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanT {
    public static void main(String[] args) {
//        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) context.getBean("person");
//        System.out.println(person);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        //获取注册的类型
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name:
             beanNamesForType) {
            System.out.println(name);
        }
    }
}
