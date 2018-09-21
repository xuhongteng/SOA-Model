# SOA-Model
@Author xuhongteng
此项目框架运用的是基于SOA系统架构的Maven+SSM+dubbo中间件的技术
搭建的是一个电商系统
总体框架是基于SSM框架的，系统架构基于SOA（面向于服务的架构）
创建了四个同级别工程，整体项目架构如下：
  1、parent Maven项目的父工程，用于统一控制依赖文件的版本号（即统一管理jar包版本号）打包方式pom
  2、common 依赖的通用工具、pojo 打包方式jar 需继承parent
  3、manager 项目的服务层 打包方式pom 继承parent 内含四个子模块：
    a.manager-pojo: 与数据库表一一对应的实体类（此项目的javabean由逆向工程generatorSqlMapCustom生成） 打包方式jar
    b.manager-dao:  存放Mapper及其映射文件，与数据库打交道，此项目中也由逆向工程生成打包方式jar 
      需依赖manager-pojo、mybatis jar包、mysql、数据库连接池
    c.manager-interface : 接口文件，此项目中将接口和实现类分别放在不同模块中是为了SOA系统架构的需要:服务层通过dubbo发布服务，服务的id即此项目中的接口
      的全映射名，对应的实现方法即为实现类的id(此id为实现类名首字母小写之后的名称，spring框架的IOC容器中每一个bean都对应有一个id，其id命名规范即首字母
      小写的类名，由于我们使用的是@Service注解方式来完成bean的自动注入，所以自动为我们创建了首字母小写的类名的id，我们通过id名即可在IOC容器中查找到对应
      的实现类，注解形式注入id皆如此，服务层通过dubbo中间件发布服务至zookeeper后，表现层即可通过接口id使用dubbo调用zookeeper上的服务) 
      需依赖 manger-pojo 打包方式jar
   4、manager-service: 存放实现类方法，需要配置一个spring容器加载spring配置文件，包含五个配置文件
      a.SqlMapConfig.xml：为mybatis的相关配置文件，由于后期会使用到mybatis分页插件，所以在此文件中配置PageHeleper的插件，其余配置信息交给spring进行
        管理
      b.
      
