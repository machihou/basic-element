## docker 安装 RabbitMq

pull
```docker
docker pull rabbitmq:3.7.7-management
```
run

```docker
docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 -p 25672:25672 -p 61613:61613 -p 1883:1883 rabbitmq:3.7.7-management
```




## 异常

1.reply-code=404, reply-text=NOT_FOUND - no queue 'XXX' in vhost '/', class-id=50, method-id=10

需要在 登录地址:http://localhost:15672/  中的Queue中add一个queue