## hellojavaX是个简单版的JAVA项目结构demo(未使用gradle标准项目结构)

#### 目录结构
```
hellojavaX/
          Main.java
          p1/
             Test1.java
          p2/
             Test2.java
```

## 编译/运行
```
cd hellojavaX/../    # 敲命令时必须和hellojavaX在同一级目录才行,这样helljavaX才在当前目录!
javac hellojavaX/Main.java   
java hellojavaX/Main

/*
因为CLASSPATH的路径里面是包含[当前路径]的,
所以编译时想要让解释器能够找到当前项目路径(就是代码里声明的根包hellojavaX),
就必须在[和hellojavaX根包同一级的文件夹/也就是它的外层文件夹]里面敲javac/java来编译/运行.
否则就会报找不到项目路径找不到class的错误!!

(所以也可以有另一种做法: 把项目的根包的外层文件夹的路径加入CLASSPATH即可认识了.)
*/
```







