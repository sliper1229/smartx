jar启动方式：java -jar target/service-application-0.0.1-SNAPSHOT.jar

默认扫描启动类同级目录、子级目录下全部注解的类
获取@ComponentScan注解basePackages属性值
获取@ComponentScan注解basePackageClasses属性值
将Application入口类所在的package作为默认的basePackages

自定义事件听器：
https://blog.yuqiyu.com/spring-boot-basic-events-and-listeners.html?from=jianshu
业务解耦利器Event/Listener：
https://blog.yuqiyu.com/spring-event-listener.html

自定义配置文件：https://blog.yuqiyu.com/spring-boot-basic-load-order-of-config-files.html
java -jar project-sample.jar --spring.config.name=custome
java -jar project-sample.jar --spring.config.location=classpath:/configs/custome.yml
java -jar project-sample.jar --spring.config.location=classpath:/configs/custome.yml,classpath:/configs/default.properties

https://blog.csdn.net/weixin_30391339/article/details/97966411
https://www.cnblogs.com/huahua035/p/7680607.html

1、从父模块继承版本
<parent>是本模块用的，复用父POM <dependencies>和<dependencyManagement>中的依赖
复用父POM <dependencies>：父POM引用的依赖，子模块无需引用，直接使用
复用父POM <dependencyManagement>：子类需要引入，不需要选版本

2、在自己模块进行版本管理，解决单继承问题
<scope>import</scope>：只能放在只能放在<dependencyManagement>里，复用<dependencies>中的依赖


        子POM                          父POM
A B C 都依赖 xxx.jar        xxx.jar 放在 <dependencies>
A B 依赖 xxx.jar C不依赖     xxx.jar 放在 <dependencyManagement> 进行版本管理
===> 尽量不要在 parent pom 里写<dependencies>，除非所有 child 项目都*必须*有这个依赖
api最好不要有parent

maven中parent标签的使用:
https://blog.csdn.net/kagurawill/article/details/84871111