## Servlet开发步骤
Servlet之于java,其实就类似python的WSGI,      
其实就是http server与你的web应用之间约定好的接口规范。      

- 写好Servlet代码(继承Servlet类覆盖doGet/doPost等方法,自定义处理逻辑,使用@RequestMapping映射请求url)
- 编译好Servlet的.class文件放到WEB-INF/classes/目录下(或者打好jar包放到lib/目录下)
- 拷贝项目目录到webapps/目录下
- 启动jetty/tomcat即可

当然你也可以使用SpringMVC框架来开发,它只是Servlet的一层包装,     
web框架原理都类似,替你写好了很多轮子代码而已.     

[Servlet介绍参考](https://blog.csdn.net/qq_19782019/article/details/80292110)

