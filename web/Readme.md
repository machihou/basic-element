## Spring Web 添加 Servlet , Filter or WebListener

[Spring 官网描述](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#howto-add-a-servlet-filter-or-listener-as-spring-bean)


目的是具有@WebServlet @WebFilter @WebListener 等类为bean对象 被Spring 管理

因此配置方法有两种:

方法一 使用@Bean 和 @WebFilter在类上加注解 或通过其他方式 使其成为Bean

方法二 使用@ServletComponentScan扫描到@WebFilter等注解的类,他会使其成为Bean




## Validator使用教程

Spring https://docs.spring.io/spring/docs/5.2.0.M1/spring-framework-reference/core.html#validation-beanvalidation-overview


## 待加入系列

Swagger

Spring Session

限制登录实现


EnableAsync



Spring Cache

Spring Cache:https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#boot-features-caching





spring boot 二级缓存实现 和 多缓存来源问题





## 配置log4j2注意

移除maven中其他日志框架impl依赖  原理日志框架体系中的门面模式

然后引入log4j2 starter

然后配置log4j2.xml即可


## Spring Cache

共计 3个缓存

1.缓存 

一级缓存

二级缓存




# CaffeineCache

org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration


# 一二级缓存

一级缓存使用

EhcacheCache缓存

二级缓存使用

Redis缓存











# 缓存学习


1.Redis

过期时间

过期通知

cache配置


