# managesystem

# 项目介绍
 managesystem 项目，前后端分离,提供接口。
 前端使用vue.js+node.js+webpack构建的前端项目。

# 项目目录结构
  managesystem
    |-manage-system-common  公共类 注解、常量、枚举、异常处理类、工具类
    |-manage-system-compose  构件
    |-manage-system-config  配置文件 mapper、redis等配置文件
    |-manage-system-dao    数据库操作层
    |-manage-system-dto    实体转换层
    |-manage-system-facade 对外提供接口层，不处理业务逻辑 
        |-facede 接口层
        |-param 请求入参
        |-resp 返回实体
    |-manage-system-model  数据库交换实体
    |-manage-system-service  业务处理层
    |-manage-system-starter  view处理层

# 技术栈
  springboot + mybatis


