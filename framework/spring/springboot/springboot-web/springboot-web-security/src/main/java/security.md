### spring security包括多个模块:
#### - 核心模块(spring-security-core.jar):包括核心的验证和访问控制类以及接口、远程支持和基本的配置API.
任何使用Spring security的应用程序都需要这个模块.支持独立应用程序、远程客户端、服务层方法安全和JDBC用户配置.
#### - 远程调用(spring-security-remoting.jar):提供与Spring-Remoting的集成.
#### - Web网页(Spring-security-web.jar):包括网站安全相关的基础代码,包括使用Spring Security XML命令空间
进行配置,需要使用该模块.
#### - LDAP(spring-security-ldap.jar): LDAP验证和配置代码,如果使用LDAP验证和管理LDAP用户实体,需要使用该模块.
#### - ACL访问控制表(spring-security-acl.jar):ACL专门的领域对象的实现,勇于在应用程序中对特定域对象实例应用安全性.
#### -CAS(spring-security-cas.jar): Spring security的CAS客户端集成,用于CAS的SSO服务器使用Spring security
网页验证.
#### - OpenID(spring-security-openid.jar):OpenID网页验证支持,使用外部的OpenID服务器验证用户.
#### - Test(spring-security-test.jar):支持Spring Security的测试.