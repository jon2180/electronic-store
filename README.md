# Electronic Store

基于Jsp/servlet的网上购物商城

## 模块

- [x] 用户端
- [ ] 商家端
- [ ] 平台端

## 依赖说明

|               项目               |        价格        |
| :------------------------------: | :----------------: |
|       mysql-connector-java       |     数据库驱动     |
|              druid               | 数据源包，即连接池 |
|         commons-dbutils          |  封装好的jdbc工具  |
| jstl-api, javax.servlet.jsp.jstl |        JSTL        |
|  commons-fileupload, commons-io  |    文件上传处理    |
|             jackcon              |      JSON处理      |
|              junit               |      单元测试      |

## 快速启动

1. 导入 Idea IDE, 配置 jdk 版本为 11，在 gradle 管理界面点击刷新，自动下载包依赖
2. 创建数据库 shop，并运行位于 `doc/shop.sql` 进行数据库导入
3. 编辑配置文件: dfconfig.properties
4. 配置好 module， facet，artifact，然后编译进行测试
5. 配置好启动方式，尝试以 Tomcat 方式启动

## API

```text

1. 创建实体类：Address.java

2. 创建业务逻辑类：AddressService.java

3. 功能一：获取当前会员的地址列表
/member/address/list---> AddressListServlet-->AddressService
5. 功能二：新增地址
/member/address/add ---> AddressAddServlet-->AddressService--->存储到数据库 
6. 功能三：删除地址

7. 功能四：编辑地址信息

8. 功能五：设置默认地址


任务一：处理前台的类目显示
1. 由于所有前台页面都 需要展示类目列表，因为我们在ServletContextListener的contextInitialized()方法中来加载所有的类目数据。
2. 把加载出来的类目数据存放到ServletContext中，以便整个项目的Servlet/JSP中都可以访问。
3. 在JSP页面中使用EL表达式就能获取到类目列表数据了。。

任务二、前台首页


1. --/index.jsp--foward--> /main --->IndexServlet-->XxxService取数据---> /main.jsp展示 ---> HTML发送给客户端浏览器 -->JS代码


任务一：商品搜索功能的实现
1. 根据用户输入“关键字”的，对商品的名字做模糊查询。
2. /search?keyword=xxxxx ---> SearchServlet ---> ProductService.find  ---> /result.jsp



day05的任务二： 完成“会员”的注册功能

/member_register.jsp  --->提交请求
                        |--MemberRegisterServlet--> 调用Service完成save()功能
                                    |-->跳转

任务三：公告
 1. 列表页：--/news/list--> NewsListServlet-->NewsService.findAll() --> /news_list.jsp
 2. 详情页: --/news/detail?id=xxx-->NewsDetailServlet-->NewsService.findOne() --> /news_detail.jsp
 
任务四：指定分类下的商品列表
 1. 指定一级分类下的：/product/list?level=top&id=xxx
 2. 指定二级分类下的：/product/list?level=second&id=xxx
任务五：热门产品列表
 1. 指定一级分类下的：/product/list?level=hots&id=xxx
任务六：“手机”分类下的产品列表
 1. 指定一级分类下的：/product/list?id=1
任务七：“电脑、平板”分类下的产品列表
  1. 指定一级分类下的：/product/list?level=hots&id=2


任务八：商品的详情页
请求流程：/product_detail?id=xxx ---> ProductDetailServlet ---> ProductService.findOne() -->/product_detail.jsp
注意：因为商品的详细描述中的图片用的是./img/xxxx.png，所以，把请求路径改在/product_detail?id=xxx格式。。。

```

## 开发进程

### 1. 开发静态页面

- HTML：编写网页的内容。标签，
- CSS：修饰网页的内容。 选择器，样式属性。
- JavaScript：页面脚本语言。完成页面中的一些动态效果，操作网页中元素。 
- [zui前端框架](https://www.openzui.com/)。编写好一套通用的CSS，我们编写网页的时候只能要使用这些CSS样式表，就能够写出漂亮。。
- [jquery](https://jquery.com/) 对常用的js操作进行了封装，更便于我们的使用。解决了浏览器的兼容问题。

gradle 的 web 工程目录结构

```text
模块名
  |-- src
    |-- main                 主代码
        |-- java             存放Java源代码的目录★
        |-- resources        存放配置文件的源目录（自定义的）
        |-- webapp           存放 Web 资源的目录★
          |-- META-INF       把 JavaWeb 项目打成 ear 包所需要配置目录
          |-- WEB-INF        JavaWeb 程序的信息目录
            |-- lib          存放第三方 jar 包的目录★
            |-- web.xml      JavaWeb 程序要有的一个配置文件(3.0以后可选的)
          |-- *.jsp、*.html、*.css、*.js、*.jpg 页面资源
    |-- test                 单元测试的源目录（自定义的）
```

本项目 web 根目录介绍

```text
|--src/main/webapp    存放所有的静态资源
  |-- css    存放自定义的CSS文件
  |-- images 存放网页中要显示的固定图片
  |-- img    存放后台管理动态添加的图片
  |-- js     存放自定义的JavaScript文件
  |-- kindeditor 第三方的富文本编辑器(暂时未使用)
  |-- zui    导入的zui框架目录
  |-- xxx.jsp jsp页面
```

四、使用JDBC执行数据库的CRUD操作

1. 在MySQL数据库服务器中创建了shop的库，创建了一个表member

```sql
 -- ----
 -- 会员表
 -- ----
 create table member(
   id               integer           primary key          auto_increment,
   mobile           varchar(32)       unique not null      comment '手机号',
   pwd              varchar(32)       not null             comment '密码',
   real_name        varchar(32)       default null         comment '真实名',
   nick_name        varchar(32)       default null         comment '昵称',
   email            varchar(128)      default null         comment '邮箱号',
   gender           tinyint(1)        default false        comment '性别，默认值false',
   register_time    datetime          comment '注册时间'
 );

 ```

1. 创建一个与会员表对应的实体类：Member.java

2. 创建一个会员业务逻辑类：MemberService.java


五、commons-dbutils.jar数据库操作工具包可以简化JDBC操作的代码。
主要使用到如下几个类和接口：

1. DbUtils类：提供一些关闭操作数据库的对象，一些事务控制方法。
2. QueryRunner类：SQL执行器。它负责把SQL发送到数据库中执行，对返回的结果进行封装。线程安全
  
    ```java
    class QueryRunner {
      public public <T> T insert(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException;
      public int update(Connection conn, String sql, Object... params) throws SQLException;
      public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException;
      // more methods
    }
    ```

3. ResultSetHandler接口（结果集处理器）几个常用子类：
    - BeanHanlder类：将结果集中的第一行数据封装到一个对应的JavaBean实例中。 注意，表的列名要跟JavaBean的属性名相同。
    - BeanListHanlder类：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。注意，表的列名要跟JavaBean的属性名相同
    - ScalarHanlder类：将结果集中某一条记录的其中某一列的数据存成 Object。
    - 也可以通过实现ResultSetHandler接口来自定义结果集处理器

day05的任务一： 完成“会员”的登录/退出功能

一、登录流程

1. 浏览器---->提交“登录”请求（参数：手机号，密码）
2. 服务器程序中用Servlet来接收请求。
3. 在Servlet中获取请求的参数（手机号，密码）
4. 调用MemberService中的业务处理方法来判断用户是否存在
5. 用户存在，Servlet就需要把用户引导到“登录成功后的页面-->会员后台首页”,用户不存在，Servlet给用户返回“登录失败”的提示

二、静态页面修改为JSP

1. 把CSS、images、JS、ZUI复制到WebContent目录下
2. 把页面公用的部分单独抽取成JSP。
        在需要使用的页面中使用include包含过去。

三、把JSP页面的中链接路径（CSS，JS，image，超链接）都应该改成相对于当前项目路径的方式。
使用ServletContextListener来实现

四、为了防止POST请求中的中文数据乱码，我们需要添加一个过滤器来处理请求数据的编码问题。

五、编写MemberLoginServlet来处理会员登录的请求。

day05的任务三：对“会员”的相关操作进行保护：

任务一：完成会员的地址管理

1. 创建表：address

```sql
-- ----
-- 会员地址表
-- ----
create table address(
  id               integer           primary key   auto_increment,
  contact          varchar(32)       not null      comment '收货人',
  mobile           varchar(32)       not null      comment '联系电话',
  street           varchar(255)      not null      comment '详细地址',
  zipcode          varchar(32)       default null  comment '邮编',
  mbr_id           integer           not null      comment '所属会员',
  default_value    tinyint(1)        default false comment '是否为所属会员的默认收货地址'
);

-- 数据
INSERT INTO address(contact, mobile, street, zipcode, mbr_id, default_value) VALUES 
 ('张三', '13902025678', '天津·西青区·津静路26号', '300384', 1, 1), 
 ('李四', '13702204321', '天津市滨海高新区华苑产业区海泰华科三路1号华鼎智地3号楼4层', '300384', 1, 0), 
 ('王5', '022-87188666', '天津市南开区华苑路26号', '300384', 1, 0);

```