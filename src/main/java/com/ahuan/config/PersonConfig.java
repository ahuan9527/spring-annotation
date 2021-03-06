package com.ahuan.config;

import com.ahuan.beans.Person;
import com.ahuan.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = {"com.ahuan"},includeFilters = {
       /* @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),*/
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//includeFilters 只扫描有的
//,excludeFilters 排除要扫描的
//FilterType.ASSIGNABLE_TYPE 按照给定的类型扫描
public class PersonConfig {

    @Bean(value = "person11")
    public Person person(){
        return  new Person("李四","20");
    }
}
