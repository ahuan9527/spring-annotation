package com.ahuan.config;


import com.ahuan.beans.Person;
import com.ahuan.condition.LinuxCon;
import com.ahuan.condition.WindowsCon;
import org.springframework.context.annotation.*;
@Conditional(WindowsCon.class) //放在类上面就是容器中是否加载这个类
@Configuration
public class ScopeTest {


    /**
     *  prototype :多实例 IOC容器并不会去调用该方法，只有获取时才会去调用
     *  singleton（默认） :单实例 ioc容器启动时就去调用放到ioc容器，所以每次获取到的都是同一个（map.get()）
     *  request: 同一次创建一个实例
     *  session: 同一个sesison创建一个实例
     *
     *  懒加载：单实例时
     * @return
     */
    @Scope("singleton")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("创建1");
        return  new Person("找一","15");
    }
    /**
     *  conditonal ：按照一定条件装配注解，满足条件的才加入IOC容器
     */
    @Conditional(LinuxCon.class)
    @Bean
    public Person person1(){

        return new Person("linux","66");
    }
    @Conditional(WindowsCon.class)
    @Bean
    public Person person2(){
        return new Person("windows","12");
    }
}
