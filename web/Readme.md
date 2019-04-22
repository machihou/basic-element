## Spring Web 添加 Servlet , Filter or WebListener

[Spring 官网描述](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#howto-add-a-servlet-filter-or-listener-as-spring-bean)


目的是具有@WebServlet @WebFilter @WebListener 等类为bean对象 被Spring 管理

因此配置方法有两种:

方法一 使用@Bean 和 @WebFilter在类上加注解 或通过其他方式 使其成为Bean

方法二 使用@ServletComponentScan扫描到@WebFilter等注解的类,他会使其成为Bean




## Validator使用教程

Spring https://docs.spring.io/spring/docs/5.2.0.M1/spring-framework-reference/core.html#validation-beanvalidation-overview

