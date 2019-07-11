# spring-annotation源码学习 #
## spring组件 ##
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
      - FilterType.CUSTOM 自定义扫描那些类
      -  @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
      -  @ComponentScan.Filter(type =      FilterType.ASSIGNABLE_TYPE,classes = {BookService.class})
   - 容器中组件的作用域scope 
      -  prototype :多实例 IOC容器并不会去调用该方法，只有获取	时才会去调用
     *  singleton（默认） :单实例 ioc容器启动时就去调用放到ioc容器，所以每次获取到的都是同一个（map.get()）
     *  request: 同一次创建一个实例
     *  session: 同一个sesison创建一个实例
   *  懒加载：@Lazy 
   *  conditonal ：按照一定条件装配注解，满足条件的才加入IOC容器
   *  放在类上面就是满足条件就加载这个类
   *  -Dos.name=Linux 指定虚拟机环境
   ![](https://i.imgur.com/C3gQY0c.png)
   ![](https://i.imgur.com/lWrbBZr.png)