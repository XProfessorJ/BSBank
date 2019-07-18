# 后端工作日志：

### 2019.7.8
确定需求：
* customer: 登录/授权/查询关联账户
* account: 查询账户余额/查询账户关联卡
* 安全: 使用token验证拦截未登录用户请求和非法用户请求

### 2019.7.9
确定系统设计方案：使用spring cloud框架
* eureka管理服务注册
* zuul实现网管功能和token验证，token保存于redis缓存
* feign集成具体服务和管理负载均衡
* customer和account服务实现具体api
   ```
   前后端交互尚未沟通完毕，以下模块api均不含controller层
   1.customer:（创建底层service）
       service: Map<String, Object> findCustomerById(String customerId);
       dao: CustomerEntity findCustomerById(String customerId);
            List<AccountEntity> getAccountsByCustomerId(String customerId);
   2.account:（创建底层service）
       service: AccountEntity findAccountByAccountId(String accountId);
                Map<String, List> getCardsByAccountId(String accountId);
       dao: AccountEntity findAccountByAccountId(String accountId);
            Map<String, List> getCardsByAccountId(String accountId);
   3.transrecord:（创建底层service）
       service: List<TransRecordWithDisplayEntity> getTransRecordListByCardId(String cardId, int pagenum, int pagerow);
                int countRecordsByCardId(String cardId);
       dao: List<TransRecordWithDisplayEntity> getTransRecordListByCardId(String cardId, int pagenum, int pagerow);
            int countRecordsByCardId(String cardId);
   4.authrization:（构建在zuul中，需要zuul配置redis）
       dao: CustomerEntity findCustomerByPhoneAndPassword(String phone, String password);
       util: public String generateToken(String phone, String password);
             public String getTokenByCustomerId(String customerId);
   ```

### 2019.7.10
* 搭建spring cloud框架（后端全员完成）
   ```
   参考链接：https://www.fangzhipeng.com/springcloud/2017/06/07/sc07-config.html
   具体pom文件参看项目
   ```
* 搭建github分布式开发环境（全员完成）
   ```
    后端：git@github.com:XProfessorJ/bsbank.git
    前端：git@github.com:XProfessorJ/BSBank-FrontEnd.git
   ```


### 2019.7.11
* 完成database创建
   ```
   数据库选择mysql
   实体表：customer/account/savingcard/creditcard/transrecord
   关系表：customer-account
   ```
* 完成entity类设计和dao层常用api，使用技术spring data jpa
* 学习spring cloud基本使用，全员实现博客demo，目前后端组员已初步具备开发能力

### 2019.7.12
* 完成customer服务全部api
* 完成token验证逻辑，zuul层验证token，token存放于zuul层redis缓存
   ```
   redis中token存储规则<customerId,token>
   存储时常30分钟
   ```
* 前后端连接已打通

### 2019.7.13
* 完成account服务除controller层外全部编码
* 具体controller map映射待与前台确认

### 2019.7.14
自由学习

### 2019.7.15
* 解决前后端跨域问题
   ```
   后端controller/filter层添加标签@CrossOrigin
   由于跨域问题，前端先发OPTIONS请求，再发GET/POST请求，因此filter中run()方法需增加如下代码对OPTIONS请求放行
   if (request.getMethod().equals("OPTIONS")) {
       return null;
   }
   ```
* 规定前后端数据传输格式
   ```
   使用json传值
   后端：
       所有Mapping映射中配置参数produces = {"application/json"}
       使用@RequestBody获取前端参数，以Map<String, Object>格式向前端传值
       增加传值实体类TokenEntity、AccountWithTokenEntity和CardIdWithTokenEntity
       login请求验证手机号和密码，正确则生成token并存入缓存传递给前端，错误则返回null
   前端：
       login请求传递phone和password用于后端验证，验证通过收到token写入cookie用于其他请求验证
       除login请求外，其他请求以post形式传token参数用于验证
   ```
   
### 2019.7.16
   基本功能已开发完毕，完成前后端具体通信规则制定，约定前后端请求转发规则如下：
   
   * zuul层路由配置：
   除验证服务zuul直接完成外，其他请求先经过feign完成负载均衡、熔断和底层服务调用
   ```
   routes:    
       customer:
           path: /customer/**
           serviceId: service-feign
       account:
           path: /account/**
           serviceId: service-feign
       transrecord:
           path: /transrecord/**
           serviceId: service-feign
       authrization:
           path: /authrization/**
           serviceId: service-zuul
   ```
   * feign层服务调用：
   启用http客户端转发请求，启用hytrix熔断
   ```        
   client:
       config:
           remote-service:
           connectTimeout: 60000
           readTimeout: 12000
       httpclient:
           enabled: true
       hytrix:
           enabled: true
   
   ```

### 2019.7.17
完成token加密，之前的请求生成token存储了用户的id和密码信息，缺乏安全性，因此增加加密处理。
修改逻辑如下：
* 修改generateToken接口，对原生token进行DES加密，缓存写入加密后的token后传递给前台  
  key：9ba45bfd500642328ec03ad8ef1b6e75
* 修改LoginFilter，获取前台传递的加密token后，增加解密验证逻辑，其他逻辑不变。

### 2019.7.18
项目总结，完成PPT整合和文档整理