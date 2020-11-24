# Mall
体验一下全流程的商城设计与开发

## Design
采用分布式微服务的架构，使用 Dubbo 完成服务间通信。

### Service Port
    admin
        ui: 8004
        service: 8005
    user
        web: 8000
        service: 8001
        dubbo: 20880
    product
        web: 8002
        service: 8003
        dubbo: 20881

## Issue
1. 使用 dubbo-2.7.0 配合 dubbo-admin-2.0.2 无法完成消费者的注册和展示，然通讯正常，且监控页面能够展示生产、消费服务间的调用关系；
