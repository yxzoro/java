## gradle-java-project-example
## java有gradle在手...太TM好用了...

#### init an java application/library/webapp project using gradle
```
mkdir projectname && cd projectname
gradle init (then choose a type)
```

#### write your code inside src/main/java/

#### modify build.gradle by your project needs

#### build jar/war file
```
gradle/gradlew build
```

#### run your jar/war file
```
gradle run (gradle version >= 6.6)
或
java -jar xx.jar -cp 包路径
```

-------------------------------------------

## gradle/gradlew usage, build.gradle file
```
gradlew: 其实就是gradle wrapper,好处就是不需要安装gradle,项目中自带gradlew的jar包,可直接运行使用,很方便.
gradlew tasks: 显示可执行的task,每个项目都会有自定义的task,例如sprintboot的bootRun.

```

-------------------------------------------
