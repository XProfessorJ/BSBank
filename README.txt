后端工作日志：

2019.7.8
确定需求：
1.customer: 登录/授权/查询关联账户
2.account: 查询账户余额/查询账户关联卡
3.安全: 使用token验证拦截未登录用户请求和非法用户请求

2019.7.9
确定系统设计方案：
使用spring cloud框架
eureka管理服务注册
zuul实现网管功能和token验证，token保存于redis缓存
feign集成具体服务和管理负载均衡
customer和account服务实现具体api

2019.7.10
搭建spring cloud框架
搭建github分布式开发环境
已全员完成

2019.7.11
完成database创建
完成entity类设计和dao层常用api
学习spring cloud基本使用，全员实现博客demo，目前后端组员已初步具备开发能力

2019.7.12
完成customer服务全部api
完成token验证逻辑
前后端连接已打通

2019.7.13
完成account服务除controller层外全部编码
具体controller map映射待与前台确认

2019.7.14
休息一天