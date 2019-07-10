# spring-annotation源码学习 #
## spring注解扫描 ##
-  在配置文件中使用
   `<context:component-scan base-package="com.ahuan"/>`
- 在配置类中使用 
   - @Configuration 加入到容器中
   - @ComponentScan 扫描注解
      - includeFilters 扫描包含的
      - excludeFilters 不扫描
      - FilterType.ASSIGNABLE_TYPE 按照给定的类型扫描
      - FilterType.REGEX 正则表达
      - FilterType.ASPECTJ 表达
      - FilterType.ASPECTJ 自定义扫描那些类
      -  @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
      -  @ComponentScan.Filter(type =      FilterType.ASSIGNABLE_TYPE,classes = {BookService.class})
      -  1