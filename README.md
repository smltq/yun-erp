# 云进销存

版本 | 修订者 | 日期
--|---|---
1 | ltq | -

### 安装说明

1. 测试/灰度/生产环境使用tomcat运行war形式，JDK 1.8以上，tomcatv8.0.42以上；
2. 引入了Lombok，IDEA请安装Lombok，file-setting-plugins 搜索lombok
3. 初始化表结构yun-erp.sql
4. 引入了swagger，项目启动后访问 http://host:port/swagger-ui.html 可访问接口文档

### 项目代码目录规划
     
    com.bbx.merchantplatform
      +- common         公共目录
        +- aop          aop目录
        +- base         基础目录
        +- config       配置目录
        +- constant     常量目录
        +- enums        枚举目录
        +- utils        工具目录
      +- mapper         dao目录
      +- model          实体目录
      +- service        服务目录
        +- impl
      +- web            web目录
        +- vo           前端交互实体目录
      YunErpApplication.java
      
  - 1、YunErpApplication.java  框架配置、项目入口
  - 2、model 目录主要用于实体
  - 3、mapper    数据访问层
  - 4、service 服务层主要是业务类代码及接口
  - 5、service/impl  业务服务目录
  - 6、web 与前端交互层，控制器等
  - 7、web/vo    前端交互实体（需要特殊定义的话)
  
### 技术选型

技术|名称|参考资料
---|---|---
spring boot|简化spring开发框架|[官网](https://spring.io/projects/spring-boot)
spring-boot-starter-web|全栈Web开发依赖|[官网](https://spring.io/projects/spring-boot)
spring-boot-devtools|热部署|
lombok|lombok依赖|
mysql-connector-java|mysql驱动|
mybatis-plus-boot-starter|orm框架|[官网](https://mp.baomidou.com/)
cn.hutool|Java工具包|[官网](https://hutool.cn/)
spring-boot-starter-test|单元测试|
swagger2|接口文档生成|[官网](https://swagger.io/docs/)
druid|数据库连接池|[GitHub仓库](https://github.com/alibaba/druid)
shiro|安全引擎|[官网](https://shiro.apache.org/)
spring-boot-starter-data-redis|redis缓存管理|[文档介绍](https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:template)
spring-session-data-redis|session redis缓存管理|[文档介绍](https://docs.spring.io/spring-session/docs/current/reference/html5/guides/java-redis.html)
commons-pool2|lettuce pool 缓存连接池|

### 功能说明

- 1.使用mybatis-pus,CRUD自动创建等功能
- 2.日志支持（控制台输出、文件输出、执行的sql打印出来、接口调用日志打印）
- 3.物理分页支持，使用mybatis-pus自带分页官网推荐的方式分页
- 5.多环境打包支持
- 6.数据库连接池(druid，监控效果查看地址：http://host:port/druid/index.html，帐号密码：admin admin)
- 7.redis缓存、缓存连接池支持
- 8.统一异常处理
- 9.接口参数防重放、放篡改攻击
- 10.跨域支持

### MySql

v1.0 : yun-erp.sql

### 权限控制说明

### 云进销存后台框架侍处理事项

    1.用户、角色、菜单、权限等管理接口提供
    2.jwt,cas,sso 实现
    3.商品管理