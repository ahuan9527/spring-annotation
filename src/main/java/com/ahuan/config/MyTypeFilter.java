package com.ahuan.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取扫描类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取扫描类的资源信息
        Resource resource = metadataReader.getResource();
        //获取扫描类名
        String className = classMetadata.getClassName();
        System.out.println("------>"+className);
        //获取注解名字

        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        Iterator<String> iterator = annotationTypes.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("注解类型--->"+next);
            if (next.contains("Controller") || next.contains("Repository")){
                return  true;
            }
        }
       /* if (className.contains("er")){
            return true;
        }*/
        return false;
    }
}
