-----------------------------------------------------------------------------------------
    java OOP .VS. python OOP (基本一样)
      *其实java和python的思想和语法在理解上是基本一样的,只是具体的写法'稍有不同'而已
      *java和python对比学习,思想相通,语法写法稍微不同而已,语言层面的差别其实并不大
      *但二者各有自己的一套语言生态,包含web开发的一系列框架工具等却需要去熟悉,花费时间.
      *(java也需要一本类似'python参考手册'的书,是啥呢?)
-----------------------------------------------------------------------------------------

## java初级知识请参考菜鸟教程...
[java初级教程-阅读菜鸟教程,看熟它先: http://www.runoob.com/java/java-modifier-types.html](http://www.runoob.com/java/java-modifier-types.html)     


#### hello world
```java
// HelloWorld.java(文件名需与类名一致,一个文件放一个public类)
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
//$ javac HelloWorld.java
//$ java HelloWorld
```

#### set JAVA_HOME, PATH, CLASSPATH
    classpath 变量:
    classpath环境变量,是当我们在开发java程序时需要引用别人写好的类时,要让java解释器知道到哪里去找这个类.
    通常,sun为我们提供了一些额外的丰富的类包,一个是dt.jar,一个是tools.jar,这两个jar包都位于JAVA_HOME\lib目录下,
    所以通常我们都会把这两个jar包加到我们的classpath(classpath=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;)

#### some notes:
    1.任何一个Java程序可以认为是一系列对象的集合,而这些对象通过调用彼此的方法来协同工作,java是完全面向对象的.
    2.所有的类名的首字母应该大写.如果类名由若干单词组成,那么每个单词的首字母应该大写,例如MyFirstJavaClass
    3.所有的方法名都应该以小写字母开头,如果方法名含有若干单词,则后面的每个单词首字母大写.
    4.源文件名必须和类名相同,当保存文件的时候,你应该使用类名作为文件名保存
    5.所有的Java程序由public static void main(String []args)方法开始执行.

#### 4种访问控制修饰符: default, public , protected, private
    修饰符            当前类        同一包内        子孙类       其他包                   
    default:           y             y              y           y
    public :           y             y              y           n
    protected:         y             y              n           n
    private:           y             n              n           n
```
1.java/python/go访问权限对比:
python通过加__来控制访问权限,go通过大小写来控制访问权限,
python和go相当于只使用java的public/private这2个访问权限的控制(因为default/protected没必要/基本用不到...)
其实实际写代码的时候基本也只会用到public/private而已,够使用了已经.
你想它能被外部访问,就用public,你想它只在class内部私有的变量,就用private,使用场景足以.
*从这一点上说,java的4种访问权限控制符就被简化了,简单实用最重要!
*在python和go里只需要使用puclic/private2种访问权限控制就足够使用了!
*java有4个来装逼,而实践证明其他2个基本用不到,就是多余的设计...所以新的语言基本只保留public/private,本来就是简单实用为上!!

2.java/python静态变量/静态方法对比,区分与实例变量/实例方法:
java在变量/方法前加static修饰符的就是静态变量/静态方法,
python没有self.的就是静态变量,加@staticmethod装饰器就是静态方法,python还多个@classmethod(没太大意义?)
(注:java里静态方法就是类方法,python里静态方法和类方法不一样(类方法多了个cls参数))
```
```
java的类(外部类)只有2种访问权限:public/default(就是说类前面要么加public修饰,要么什么都不加)
java的变量和方法有4种访问权限：public/default/protected/private,常用的2种(public/private)
```
```
java繁杂冗余的语法的那一套东西要去简化它,以简洁实用为目的.kotlin/scala的设计出发点就是为了这个吧...
```


#### 一个类可以有以下3种类型的变量:
    1.局部变量:在方法或者语句块中定义的变量被称为局部变量.变量声明和初始化都是在方法中,方法结束后,变量就会自动销毁.
    2.成员变量/实例变量:成员变量是定义在类中,方法体之外的变量.这种变量在创建对象的时候实例化.成员变量可以被类中方法和特定类的语句块访问.
    3.类变量/静态变量:类变量也声明在类中,方法体之外,但必须声明为static类型 !!(python的类变量?)

#### 实例变量和静态变量,实例方法和静态方法,区别(一个绑定到对象,一个绑定到类)
```
由static修饰的变量称为静态变量,其实质上就是一个全局变量.
如果某个内容是被所有对象所共享,那么该内容就应该用静态修饰；没有被静态修饰的内容,其实是属于对象的特殊描述.
不同的对象的实例变量将被分配不同的内存空间, 
如果类中的成员变量有类变量,那么所有对象的这个类变量都分配给相同的一处内存,改变其中一个对象的这个类变量会影响其他对象的这个类变量,也就是说对象共享类变量.

成员变量和类变量的区别:
   1/两个变量的生命周期不同
      成员变量随着对象的创建而存在,随着对象的回收而释放.
      静态变量随着类的加载而存在,随着类的消失而消失.
   2/调用方式不同
      成员变量只能被对象调用.
      静态变量可以被对象调用,还可以被类名调用.
   3/别名不同
      成员变量也称为实例变量.
      静态变量也称为类变量.
   4/数据存储位置不同
      成员变量存储在堆内存的对象中,所以也叫对象的特有数据.
      静态变量数据存储在方法区（共享数据区）的静态区,所以也叫对象的共享数据.

static 关键字,是一个修饰符,用于修饰成员(成员变量和成员函数).特点:
   1/想要实现对象中的共性数据的对象共享.可以将这个数据进行静态修饰.
   2/被静态修饰的成员,可以直接被类名所调用.也就是说,静态的成员多了一种调用方式.类名.静态方式.
   3/静态随着类的加载而加载.而且优先于对象存在.
 
弊端:
   1/有些数据是对象特有的数据,是不可以被静态修饰的.因为那样的话,特有数据会变成对象的共享数据.
      这样对事物的描述就出了问题.所以,在定义静态时,必须要明确,这个数据是否是被对象所共享的.
   2/静态方法只能访问静态成员,不可以访问非静态成员.
      因为静态方法加载时,优先于对象存在,所以没有办法访问对象中的成员.
   3/静态方法中不能使用this,super关键字.
      因为this代表对象,而静态在时,有可能没有对象,所以this无法使用.
 
什么时候定义静态成员呢？或者说:定义成员时,到底需不需要被静态修饰呢？
成员分两种:
   1/成员变量.（数据共享时静态化）
      该成员变量的数据是否是所有对象都一样:
      如果是,那么该变量需要被静态修饰,因为是共享的数据. 
      如果不是,那么就说这是对象的特有数据,要存储到对象中. 
   2/成员函数.（方法中没有调用特有数据时就定义成静态）
      如果判断成员函数是否需要被静态修饰呢？
      只要参考,该函数内是否访问了对象中的特有数据:
      如果有访问特有数据,那方法不能被静态修饰.
      如果没有访问过特有数据,那么这个方法需要被静态修饰.

成员变量和静态变量的区别:
   1/成员变量所属于对象.所以也称为实例变量.
      静态变量所属于类.所以也称为类变量.
   2/成员变量存在于堆内存中.
      静态变量存在于方法区中.
   3/成员变量随着对象创建而存在.随着对象被回收而消失.
      静态变量随着类的加载而存在.随着类的消失而消失.
   4/成员变量只能被对象所调用 .
      静态变量可以被对象调用,也可以被类名调用.
   所以,成员变量可以称为对象的特有数据,静态变量称为对象的共享数据.
```

#### 构造方法
    每个类都有构造方法.如果没有显式地为类定义构造方法,Java编译器将会为该类提供一个默认构造方法.
    在创建一个对象的时候,至少要调用一个构造方法.构造方法的名称必须与类同名,
    一个类也可以有多个构造方法(构造方法重载,可以选用不同的初始化).
```java
public class Puppy{
    public Puppy(){
    }
    public Puppy(String name){
    }
}
Puppy p1 = new Puppy();
Puppy p2 = new Puppy("haha");
```

#### 源文件声明规则
    一个源文件中只能有一个public类
    一个源文件可以有多个非public类
    源文件的名称应该和public类的类名保持一致.例如:源文件中public类的类名是Employee,那么源文件应该命名为Employee.java.
    如果一个类定义在某个包中,那么package语句应该在源文件的首行.
    如果源文件包含import语句,那么应该放在package语句和类定义之间.如果没有package语句,那么import语句应该在源文件中最前面.
    import语句和package语句对源文件中定义的所有类都有效

#### Java包
    包主要用来对类和接口进行分类.
    package haha
    import java.io.*;

#### 8种基本类型
*Java语言提供了八种基本类型.六种数字类型（四个整数型,两个浮点型）,一种字符类型,还有一种布尔型*
```java
byte:  (包装类:java.lang.Byte)
    byte 数据类型是8位/有符号的,以二进制补码表示的整数；
    最小值是 -128（-2^7）；
    最大值是 127（2^7-1）；
    默认值是 0；
    byte 类型用在大型数组中节约空间,主要代替整数,因为 byte 变量占用的空间只有 int 类型的四分之一；
    例子:byte a = 100,byte b = -50.
short:  (包装类:java.lang.Short)
    short 数据类型是 16 位/有符号的以二进制补码表示的整数
    最小值是 -32768（-2^15）；
    最大值是 32767（2^15 - 1）；
    Short 数据类型也可以像 byte 那样节省空间.一个short变量是int型变量所占空间的二分之一；
    默认值是 0；
    例子:short s = 1000,short r = -20000.
int:  (包装类:java.lang.Integer)
    int 数据类型是32位/有符号的以二进制补码表示的整数；
    最小值是 -2,147,483,648（-2^31）；
    最大值是 2,147,483,647（2^31 - 1）；
    一般地整型变量默认为 int 类型；
    默认值是 0 ；
    例子:int a = 100000, int b = -200000.
long:  (包装类:java.lang.Long)
    long 数据类型是 64 位/有符号的以二进制补码表示的整数；
    最小值是 -9,223,372,036,854,775,808（-2^63）；
    最大值是 9,223,372,036,854,775,807（2^63 -1）；
    这种类型主要使用在需要比较大整数的系统上；
    默认值是 0L；
    例子: long a = 100000L,Long b = -200000L.
    "L"理论上不分大小写,但是若写成"l"容易与数字"1"混淆,不容易分辩.所以最好大写.
float:  (包装类:java.lang.Float)
    float 数据类型是单精度/32位/符合IEEE 754标准的浮点数；
    float 在储存大型浮点数组的时候可节省内存空间；
    默认值是 0.0f；
    浮点数不能用来表示精确的值,如货币；
    例子:float f1 = 234.5f.
double:  (包装类:java.lang.Double)
    double 数据类型是双精度/64 位/符合IEEE 754标准的浮点数；
    浮点数的默认类型为double类型；
    double类型同样不能表示精确的值,如货币；
    默认值是 0.0d；
    例子:double d1 = 123.4.
boolean:  (包装类:java.lang.Boolean)
    boolean数据类型表示一位的信息；
    只有两个取值:true 和 false；
    这种类型只作为一种标志来记录 true/false 情况；
    默认值是 false；
    例子:boolean one = true.
char:  (包装类:java.lang.Character)
    char类型是一个单一的 16 位 Unicode 字符；
    最小值是 \u0000（即为0）；
    最大值是 \uffff（即为65,535）；
    char 数据类型可以储存任何字符；
    例子:char letter = 'A';.
void:
实际上,JAVA中还存在另外一种基本类型void,它也有对应的包装类 java.lang.Void,不过我们无法直接对它们进行操作.    
```

#### 引用数据类型
```
在Java中,引用类型的变量非常类似于C/C++的指针.
引用类型指向一个对象,指向对象的变量是引用变量.这些变量在声明时被指定为一个特定的类型,比如 Employee/Puppy 等.变量一旦声明后,类型就不能被改变了.
对象/数组都是引用数据类型.
所有引用类型的默认值都是null.
一个引用变量可以用来引用任何与之兼容的类型.
例子:Site site = new Site("Runoob").
```

#### Java 常量
```
//通常使用大写字母表示常量
final double PI = 3.1415927;
```

#### 自动类型转换
    整型/实型（常量）/字符型数据可以混合运算.运算中,不同类型的数据先转化为同一类型,然后进行运算.
    转换从低级到高级.
    byte,short,char—> int —> long—> float —> double 
    数据类型转换必须满足如下规则:

    1. 不能对boolean类型进行类型转换.
    2. 不能把对象类型转换成不相关类的对象.
    3. 在把容量大的类型转换为容量小的类型时必须使用"强制类型转换"
    4. 转换过程中可能导致溢出或损失精度,例如:
        int i =128;   
        byte b = (byte)i;
        因为 byte 类型是 8 位,最大值为127,所以当强制转换为 int 类型值 128 时候就会导致溢出.
    5. 浮点数到整数的转换是通过舍弃小数得到,而不是四舍五入,例如:
        (int)23.7 == 23;        
        (int)-45.89f == -45

#### 强制类型转换
```java
1. 条件是转换的数据类型必须是兼容的.
2. 格式:(type)value type是要强制类型转换后的数据类型 实例:
public class QiangZhiZhuanHuan{
    public static void main(String[] args){
        int i1 = 123;
        byte b = (byte)i1;//强制类型转换为byte
        System.out.println("int强制类型转换为byte后的值等于"+b);
    }
}
```

#### Java 局部变量
```java
//局部变量声明在方法/构造方法或者语句块中；
//局部变量在方法/构造方法/或者语句块被执行的时候创建,当它们执行完成后,变量将会被销毁；
//访问修饰符不能用于局部变量；
//局部变量只在声明它的方法/构造方法或者语句块中可见；
//局部变量是在栈上分配的.
//局部变量没有默认值,所以局部变量被声明后,必须经过初始化,才可以使用.
package com.runoob.test;
public class Test{ 
   public void pupAge(){
      int age = 0;
      age = age + 7;
      System.out.println("小狗的年龄是: " + age);
   }
   public static void main(String args[]){
      Test test = new Test();
      test.pupAge();
   }
}
```

#### 实例变量
```java
实例变量声明在一个类中,但在方法/构造方法和语句块之外；
当一个对象被实例化之后,每个实例变量的值就跟着确定；
实例变量在对象创建的时候创建,在对象被销毁的时候销毁；
实例变量的值应该至少被一个方法/构造方法或者语句块引用,使得外部能够通过这些方式获取实例变量信息；
实例变量可以声明在使用前或者使用后；
访问修饰符可以修饰实例变量；
实例变量对于类中的方法/构造方法或者语句块是可见的.一般情况下应该把实例变量设为私有.通过使用访问修饰符可以使实例变量对子类可见；
实例变量具有默认值.数值型变量的默认值是0,布尔型变量的默认值是false,引用类型变量的默认值是null.变量的值可以在声明时指定,也可以在构造方法中指定；
实例变量可以直接通过变量名访问.但在静态方法以及其他类中,就应该使用完全限定名:ObejectReference.VariableName.
import java.io.*;
public class Employee{
   // 这个实例变量对子类可见
   public String name;
   // 私有变量,仅在该类可见
   private double salary;
   public Employee (String empName){
      name = empName;
   }
   public void setSalary(double empSal){
      salary = empSal;
   }  
   public void printEmp(){
      System.out.println("名字 : " + name );
      System.out.println("薪水 : " + salary);
   }
   public static void main(String args[]){
      Employee empOne = new Employee("RUNOOB");
      empOne.setSalary(1000);
      empOne.printEmp();
   }
}
```

#### 类变量（静态变量）
```
类变量也称为静态变量,在类中以static关键字声明,但必须在方法构造方法和语句块之外.
无论一个类创建了多少个对象,类只拥有类变量的一份拷贝.
静态变量除了被声明为常量外很少使用.常量是指声明为public/private,final和static类型的变量.常量初始化后不可改变.
静态变量储存在静态存储区.经常被声明为常量,很少单独使用static声明变量.
静态变量在程序开始时创建,在程序结束时销毁.
与实例变量具有相似的可见性.但为了对类的使用者可见,大多数静态变量声明为public类型.
默认值和实例变量相似.数值型变量默认值是0,布尔型默认值是false,引用类型默认值是null.变量的值可以在声明的时候指定,也可以在构造方法中指定.此外,静态变量还可以在静态语句块中初始化.
静态变量可以通过:ClassName.VariableName的方式访问.
类变量被声明为public static final类型时,类变量名称一般建议使用大写字母.如果静态变量不是public和final类型,其命名方式与实例变量以及局部变量的命名方式一致.
import java.io.*;
public class Employee {
    //salary是静态的私有变量
    private static double salary;
    // DEPARTMENT是一个常量
    public static final String DEPARTMENT = "开发人员";
    public static void main(String args[]){
    salary = 10000;
        System.out.println(DEPARTMENT+"平均工资:"+salary);
    }
}
```

#### Java 访问控制修饰符
    Java中,可以使用访问控制符来保护对类/变量/方法的访问.Javav支持 4 种不同的访问权限.
        default (即缺省,什么也不写）: 在同一包内可见,不使用任何修饰符.使用对象:类/接口/变量/方法.
        private : 在同一类内可见.使用对象:变量/方法. 注意:不能修饰类（外部类）
        public : 对所有类可见.使用对象:类/接口/变量/方法
        protected : 对同一包内的类和所有子类可见.使用对象:变量/方法. 注意:不能修饰类（外部类）.

#### 私有访问修饰符 private
```java
私有访问修饰符是最严格的访问级别,所以被声明为 private 的方法/变量和构造方法只能被所属类访问,并且类和接口不能声明为 private.
声明为私有访问类型的变量只能通过类中公共的 getter 方法被外部类访问.
Private 访问修饰符的使用主要用来隐藏类的实现细节和保护类的数据.
public class Logger {
   private String format;
   public String getFormat() {
      return this.format;
   }
   public void setFormat(String format) {
      this.format = format;
   }
}
实例中,Logger 类中的 format 变量为私有变量,所以其他类不能直接得到和设置该变量的值.
为了使其他类能够操作该变量,定义了两个 public 方法:getFormat() （返回 format的值）和 setFormat(String)（设置 format 的值）
```

####　公有访问修饰符-public
```java
被声明为 public 的类/方法/构造方法和接口能够被任何其他类访问.
如果几个相互访问的 public 类分布在不同的包中,则需要导入相应 public 类所在的包.
由于类的继承性,类所有的公有方法和变量都能被其子类继承.
public static void main(String[] arguments) {
   // ...
}
Java 程序的 main() 方法必须设置成公有的,否则,Java 解释器将不能运行该类.
```

#### 受保护的访问修饰符-protected
```java
被声明为 protected 的变量/方法和构造器能被同一个包中的任何其他类访问,也能够被不同包中的子类访问.
protected 访问修饰符不能修饰类和接口,方法和成员变量能够声明为 protected,但是接口的成员变量和成员方法不能声明为 protected.
子类能访问 protected 修饰符声明的方法和变量,这样就能保护不相关的类使用这些方法和变量.
class AudioPlayer {
   protected boolean openSpeaker(Speaker sp) {
      // ...
   }
} 
class StreamingAudioPlayer extends AudioPlayer {
   protected boolean openSpeaker(Speaker sp) {
      // ...
   }
}
如果把 openSpeaker() 方法声明为 private,那么除了 AudioPlayer 之外的类将不能访问该方法.
如果把 openSpeaker() 声明为 public,那么所有的类都能够访问该方法.
**如果我们只想让该方法对其所在类的子类可见,则将该方法声明为 protected.**
```

#### 访问控制和继承
    请注意以下方法继承的规则：
    父类中声明为 public 的方法在子类中也必须为 public。
    父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
    父类中声明为 private 的方法，不能够被继承。


#### 非访问修饰符
    static 修饰符，用来修饰类方法和类变量。
    final 修饰符，用来修饰类、方法和变量，final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
    abstract 修饰符，用来创建抽象类和抽象方法。
    synchronized 和 volatile 修饰符，主要用于线程的编程。

#### static 修饰符
    静态变量：
        static关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。
    静态方法：
        static关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。静态方法从参数列表得到数据，然后计算这些数据。
    对类变量和方法的访问可以直接使用 classname.variablename 和 classname.methodname 的方式访问。
```java
public class InstanceCounter {
   private static int numInstances = 0;
   protected static int getCount() {
      return numInstances;
   }
 
   private static void addInstance() {
      numInstances++;
   }
 
   InstanceCounter() {
      InstanceCounter.addInstance();
   }
 
   public static void main(String[] arguments) {
      System.out.println("Starting with " +
      InstanceCounter.getCount() + " instances");
      for (int i = 0; i < 500; ++i){
         new InstanceCounter();
          }
      System.out.println("Created " +
      InstanceCounter.getCount() + " instances");
   }
}
```

#### final修饰符
```java
final 变量：
final 变量能被显式地初始化并且只能初始化一次。被声明为 final 的对象的引用不能指向不同的对象。
但是 final 对象里的数据可以被改变。也就是说 final 对象的引用不能改变，但是里面的值可以改变。
final 修饰符通常和 static 修饰符一起使用来创建类常量。
public class Test{
  final int value = 10;
  public static final int BOXWIDTH = 6;
  static final String TITLE = "Manager";
 
  public void changeValue(){
     value = 12;  //将输出一个错误
  }
}

final 方法
类中的 final 方法可以被子类继承，但是不能被子类修改。
声明 final 方法的主要目的是防止该方法的内容被修改。
如下所示，使用 final 修饰符声明方法。
public class Test{
    public final void changeName(){
       //...
    }
}

final 类
final 类不能被继承，没有类能够继承 final 类的任何特性。
实例
public final class Test {
   //...
}

```

#### abstract修饰符
```
抽象类：
抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
抽象类可以包含抽象方法和非抽象方法。
abstract class Caravan{
   private double price;
   private String model;
   private String year;
   public abstract void goFast(); //抽象方法
   public abstract void changeColor();
}

抽象方法
抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
抽象方法不能被声明成 final 和 static。
任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。
抽象方法的声明以分号结尾，没有方法体. 例如：public abstract sample();。
public abstract class SuperClass{
    abstract void m(); //抽象方法
}
class SubClass extends SuperClass{
      void m(){
          //...
      }
}
```

#### synchronized 修饰符
```
synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。
public synchronized void showDetails(){
    //...
}
```

#### transient 修饰符
```
序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。
该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。
public transient int limit = 55;   // 不会持久化
public int b; // 持久化
```

#### volatile 修饰符
```
volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
一个 volatile 对象引用可能是 null。
public class MyRunnable implements Runnable
{
    private volatile boolean active;
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            // 代码
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}
通常情况下，在一个线程调用 run() 方法（在 Runnable 开启的线程），在另一个线程调用 stop() 方法。 
如果 第一行 中缓冲区的 active 值被使用，那么在 第二行 的 active 值为 false 时循环不会停止。
但是以上代码中我们使用了 volatile 修饰 active，所以该循环会停止。
```

#### 三元运算符 ?:
```java
a = 10;
b = (a == 1) ? 20 : 30;  // 如果 a 等于 1 成立，则设置 b 为 20，否则为 30
```

#### instanceof 运算符
```java
//该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。
Vehicle a = new Car();
boolean result =  a instanceof Car;
```

#### 循环判断语句
```java
// while
public class Test {
   public static void main(String args[]) {
      int x = 10;
      while( x < 20 ) {
         System.out.print("value of x : " + x );
         x++;
      }
   }
}

// do while
public class Test {
   public static void main(String args[]){
      int x = 10; 
      do{
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }while( x < 20 );
   }
}

// for
public class Test {
   public static void main(String args[]) {
      for(int x = 10; x < 20; x = x+1) {
         System.out.print("value of x : " + x );
         System.out.print("\n");
      }
   }
}

// 增强for
public class Test {
   public static void main(String args[]){
      int [] numbers = {10, 20, 30, 40, 50};
      for(int x : numbers ){
         System.out.print( x );
      }
      String [] names ={"James", "Larry", "Tom", "Lacy"};
      for( String name : names ) {
         System.out.print( name );
      }
   }
}

//if else
public class Test {
   public static void main(String args[]){
      int x = 30;
      if( x == 10 ){
         System.out.print("Value of X is 10");
      }else if( x == 20 ){
         System.out.print("Value of X is 20");
      }else if( x == 30 ){
         System.out.print("Value of X is 30");
      }else{
         System.out.print("这是 else 语句");
      }
   }
}

//switch
public class Test {
   public static void main(String args[]){
      char grade = 'C'; 
      switch(grade)
      {
         case 'A' :
            System.out.println("优秀"); 
            break;
         case 'D' :
            System.out.println("及格");
         default :
            System.out.println("未知等级");
      }
   }
}
```

#### 基本类型的包装类
```
我们经常会遇到需要使用对象，而不是内置数据类型的情形(为了调用这个类型的某些通用方法)。Java 语言为每一个内置数据类型提供了对应的包装类
在python中,int等不需要包装类,本身就是对象--python里一切皆对象,包括基本类型,它们可以直接调用自身的静态方法.
而java里基本类型的很多静态方法都存在其包装类当中,必须调用其包装类才能使用它们.
**java里提供包装类这个东西,是为了使基本类型也可以类似python里那样直接当成对象来使用了 !!

基本类型      包装类
byte          java.lang.Byte
short         java.lang.Short
int           java.lang.Integer
long          java.lang.Long
float         java.lang.Float
double        java.lang.Double
boolean       java.lang.Boolean
char          java.lang.Character
```
```
//所有的数字类型的包装类（Integer、Long、Byte、Double、Float、Short）都是抽象类 Number 的子类。
//自动拆装箱(就是支持基本类型和其包装类的自动转换,在后起的python/ruby等语言中,这个都是不屑一提的功能了...)：
public class Test{
   public static void main(String args[]){
      Integer x = 5;    // 装箱
      x =  x + 10;      // 拆箱
      System.out.println(x); 
   }
}
```

#### 几个常用包装类相关的静态方法
```java
//Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数.Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。
Math.sin(Math.PI/2);  

//Number子类
Integer x = 5;   //即使使用int a = 5; a也可以直接调用Interger类的各种方法,因为有'自动拆装箱嘛',
x.toString();    //自动拆装箱的作用就体现在这里:使得int和Integer类的使用一致,感觉不到切换("int也是对象了").
x.abs();         //从原理上解释,java是通过'自动拆装箱'来做的,从使用上来说,你感觉不到切换,感觉和使用python的int对象效果一样了.
x =  x + 10;

//Character类
Character ch = new Character('a');   // char ch = 'a';
ch.toUpperCase()

//

```

#### String和StringBuilder/StringBuffer类
```java
//在 Java 中字符串属于对象，Java 提供了 String 类来创建和操作字符串。
//String类的简易写法会使你误以为String是java的基本类型呢...其实是在使用String类,且String类是不可变类型(和python的string不可变原理一样)
//修改字符串变量只是修改该变量指向不同的字符串对象而已,而不是修改该字符串对象本身.
String greeting = "runoob";
String helloString = new String({ 'r', 'u', 'n', 'o', 'o', 'b'}); 
greeting = "haha";
greeting.length();
//String.format()
fs = String.format("浮点型变量的值为 " +
                   "%f, 整型变量的值为 " +
                   " %d, 字符串变量的值为 " +
                   " %s", floatVar, intVar, stringVar);

//StringBuilder类型是String的增强版,是可变的!
//StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
//StringBuilder 类和 StringBuffer 的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
//由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
//然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
public class Test{
  public static void main(String args[]){
    StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
    sBuffer.append("www");
    sBuffer.append(".runoob");
    sBuffer.append(".com");
    System.out.println(sBuffer);  
  }
}
```

# java常用的容器类(它们都在java.util包里面,一般直接import java.util.* )
## 数组
```java
//数组是用来存储固定大小的同类型元素
Type[] array = new Type[Size];
Type[] array = {value0, value1, ..., valuek};

public class TestArray {
   public static void main(String[] args) {
      int size = 10;
      double[] myList = new double[size];
      myList[0] = 5.6;
      myList[1] = 4.5;
      double total = 0;
      //使用普通for循环遍历
      for (int i = 0; i < size; i++) {
         total += myList[i];
      }
      System.out.println("总和为： " + total);
   }
}
//使用foreach循环遍历
//JDK1.5引进了一种新的循环类型，被称为 foreach 循环或者加强型循环，它能在不使用下标的情况下遍历数组。
public class TestArray {
   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5}; 
      for (double element: myList) {
         System.out.println(element);
      }
   }
}

//多维数组
String str[][] = new String[3][4];

/*
java.util.Arrays类能方便地操作数组，它提供的所有方法都是静态的.具有以下功能：
给数组赋值：通过 fill 方法。
对数组排序：通过 sort 方法,按升序。
比较数组：通过 equals 方法比较数组中元素值是否相等。
查找数组元素：通过 binarySearch 方法能对排序好的数组进行二分查找法操作。
*/
```

## Map
```java

```

## Date类
```java
//java.util包提供了Date类来封装当前的日期和时间,Date类提供两个构造函数来实例化 Date 对象。
第一个构造函数使用当前日期和时间来初始化对象:
Date()

第二个构造函数接收一个参数，该参数是从1970年1月1日起的毫秒数:
Date(long millisec)

//Java中获取当前日期和时间很简单,使用Date对象的 toString() 方法来打印当前日期和时间:
import java.util.Date;  
public class DateDemo {
   public static void main(String args[]) {
       Date date = new Date();        
       System.out.println(date.toString());
   }
}

//Java使用以下三种方法来比较两个日期：
使用 getTime()方法获取两个日期（自1970年1月1日经历的毫秒数值），然后比较这两个值。
使用方法before(),after()和equals().例如,一个月的12号比18号早,则new Date(99, 2, 12).before(new Date (99, 2, 18))返回true
使用compareTo() 方法，它是由 Comparable 接口定义的，Date 类实现了这个接口

//下面的一个例子表明如何测量时间间隔（以毫秒为单位）：
import java.util.*;  
public class DiffDemo {
   public static void main(String args[]) {
      try {
         long start = System.currentTimeMillis( );
         System.out.println(new Date( ) + "\n");
         Thread.sleep(5*60*10);
         System.out.println(new Date( ) + "\n");
         long end = System.currentTimeMillis( );
         long diff = end - start;
         System.out.println("Difference is : " + diff);
      } catch (Exception e) {
         System.out.println("Got an exception!");
      }
   }
}
```

## Calendar类
```java
/*我们现在已经能够格式化并创建一个日期对象了，但是我们如何才能设置和获取日期数据的特定部分呢，比如说小时，日，或者分钟? 
答案是使用Calendar 类。Calendar类的功能要比Date类强大很多，而且在实现方式上也比Date类要复杂一些。
Calendar类是一个抽象类，在实际使用时实现特定的子类的对象，只需要使用getInstance方法创建即可 */

//创建一个代表系统当前日期的Calendar对象
Calendar c = Calendar.getInstance();//默认是当前日期
//把c1对象的日期加上10，也就是c1也就表示为10天后的日期，其它所有的数值会被重新计算
c.add(Calendar.DATE, 10);
```

## 正则表达式
```java
/*
java.util.regex 包主要包括以下三个类：

Pattern 类：
pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。
要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。
该方法接受一个正则表达式作为它的第一个参数。

Matcher 类：
Matcher 对象是对输入字符串进行解释和匹配操作的引擎。
与Pattern类一样,Matcher也没有公共构造方法.你需要调用Pattern对象的matcher方法来获得一个Matcher对象

PatternSyntaxException：
PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
*/

/*
使用正则表达式来捕获组(和python的re一样)
捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：
((A)(B(C)))
(A)
(B(C))
(C)
*/
import java.util.regex.*;
 
public class RegexMatches
{
    public static void main( String args[] ){
      // 按指定模式在字符串查找
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(\\D*)(\\d+)(.*)";
 
      // 创建 Pattern 对象
      Pattern r = Pattern.compile(pattern);
 
      // 现在创建 matcher 对象
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
         System.out.println("Found value: " + m.group(3) ); 
      } else {
         System.out.println("NO MATCH");
      }
   }
}

/* 注意:
在其他的语言中，一个反斜杠\就足以具有转义的作用，而在java正则表达式中则需要有两个反斜杠才能被解析为其他语言中的转义作用。
也可以简单的理解在正则表达式中，java里两个 \ 代表其他语言中的一个 \，
这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。
*/

//使用replaceAll方法用来替换匹配正则表达式的文本。replaceAll 替换所有匹配:
import java.util.regex.*;
public class RegexMatches
{
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. All dogs say meow.";
    private static String REPLACE = "cat";
 
    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       Matcher m = p.matcher(INPUT); 

       INPUT = m.replaceAll(REPLACE);
       System.out.println(INPUT);
   }
}
```

## java方法的定义
```
修饰符 返回值类型 方法名(参数类型 参数名){
    ...
    方法体;
    ...
    return 返回值;
}


可变参数
JDK 1.5 开始，Java的方法支持传递同类型的可变参数(实际上背后是用java数组实现的!)

方法的可变参数的声明如下所示：
type... parameterName

在方法声明中，在指定参数类型后加一个省略号(...) 
一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明。
public class VarargsDemo {
    public static void main(String args[]) {
        // 调用可变参数的方法
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});  //同类型可变参数就是用数组实现...
    }
 
    public static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }
 
        double result = numbers[0];
 
        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}

Java 教程
Java 教程
Java 简介
Java 开发环境配置
Java 基础语法
Java 对象和类
Java 基本数据类型
Java 变量类型
Java 修饰符
Java 运算符
Java 循环结构
Java 分支结构
Java Number & Math 类
Java Character 类
Java String 类
Java StringBuffer
Java 数组
Java 日期时间
Java 正则表达式
Java 方法
Java Stream、File、IO
Java Scanner 类
Java 异常处理

Java 面向对象
Java 继承
Java Override/Overload
Java 多态
Java 抽象类
Java 封装
Java 接口
Java 包(package)

Java 高级教程
Java 数据结构
Java 集合框架
Java 泛型
Java 序列化
Java 网络编程
Java 发送邮件
Java 多线程编程
Java Applet 基础
Java 文档注释
Java 实例
Java 8 新特性
Java MySQL 连接
 Java 正则表达式 Java 流(Stream)、文件(File)和IO 
Java 方法
在前面几个章节中我们经常使用到 System.out.println()，那么它是什么呢？

println() 是一个方法。
System 是系统类。
out 是标准输出对象。
这句话的用法是调用系统类 System 中的标准输出对象 out 中的方法 println()。
那么什么是方法呢？
Java方法是语句的集合，它们在一起执行一个功能。

方法是解决一类问题的步骤的有序组合
方法包含于类或对象中
方法在程序中被创建，在其他地方被引用
方法的优点
1. 使程序变得更简短而清晰。
2. 有利于程序维护。
3. 可以提高程序开发的效率。
4. 提高了代码的重用性。
方法的命名规则
1.方法的名字的第一个单词应以小写字母作为开头，后面的单词则用大写字母开头写，不使用连接符。例如：addPerson。
2.下划线可能出现在 JUnit 测试方法名称中用以分隔名称的逻辑组件。一个典型的模式是：test<MethodUnderTest>_<state>，例如 testPop_emptyStack。
方法的定义
一般情况下，定义一个方法包含以下语法：

修饰符 返回值类型 方法名(参数类型 参数名){
    ...
    方法体
    ...
    return 返回值;
}
方法包含一个方法头和一个方法体。下面是一个方法的所有部分：

修饰符：修饰符，这是可选的，告诉编译器如何调用该方法。定义了该方法的访问类型。
返回值类型 ：方法可能会返回值。returnValueType 是方法返回值的数据类型。有些方法执行所需的操作，但没有返回值。在这种情况下，returnValueType 是关键字void。
方法名：是方法的实际名称。方法名和参数表共同构成方法签名。
参数类型：参数像是一个占位符。当方法被调用时，传递值给参数。这个值被称为实参或变量。参数列表是指方法的参数类型、顺序和参数的个数。参数是可选的，方法可以不包含任何参数。
方法体：方法体包含具体的语句，定义该方法的功能。


如：

public static int age(int birthday){...}
参数可以有多个：

static float interest(float principal, int year){...}
注意： 在一些其它语言中方法指过程和函数。一个返回非void类型返回值的方法称为函数；一个返回void类型返回值的方法叫做过程。

实例
下面的方法包含 2 个参数 num1 和 num2，它返回这两个参数的最大值。

/** 返回两个整型变量数据的较大值 */
public static int max(int num1, int num2) {
   int result;
   if (num1 > num2)
      result = num1;
   else
      result = num2;
 
   return result; 
}
方法调用
Java 支持两种调用方法的方式，根据方法是否返回值来选择。

当程序调用一个方法时，程序的控制权交给了被调用的方法。当被调用方法的返回语句执行或者到达方法体闭括号时候交还控制权给程序。

当方法返回一个值的时候，方法调用通常被当做一个值。例如：

int larger = max(30, 40);
如果方法返回值是void，方法调用一定是一条语句。例如，方法println返回void。下面的调用是个语句：

System.out.println("欢迎访问菜鸟教程！");
示例
下面的例子演示了如何定义一个方法，以及如何调用它：

TestMax.java 文件代码：
public class TestMax {
   /** 主方法 */
   public static void main(String[] args) {
      int i = 5;
      int j = 2;
      int k = max(i, j);
      System.out.println( i + " 和 " + j + " 比较，最大值是：" + k);
   }
 
   /** 返回两个整数变量较大的值 */
   public static int max(int num1, int num2) {
      int result;
      if (num1 > num2)
         result = num1;
      else
         result = num2;
 
      return result; 
   }
}
以上实例编译运行结果如下：

5 和 2 比较，最大值是：5
这个程序包含 main 方法和 max 方法。main 方法是被 JVM 调用的，除此之外，main 方法和其它方法没什么区别。

main 方法的头部是不变的，如例子所示，带修饰符 public 和 static,返回 void 类型值，方法名字是 main,此外带个一个 String[] 类型参数。String[] 表明参数是字符串数组。

void 关键字
本节说明如何声明和调用一个 void 方法。

下面的例子声明了一个名为 printGrade 的方法，并且调用它来打印给定的分数。

示例
TestVoidMethod.java 文件代码：
public class TestVoidMethod {
  public static void main(String[] args) {
    printGrade(78.5);
  }
 
  public static void printGrade(double score) {
    if (score >= 90.0) {
       System.out.println('A');
    }
    else if (score >= 80.0) {
       System.out.println('B');
    }
    else if (score >= 70.0) {
       System.out.println('C');
    }
    else if (score >= 60.0) {
       System.out.println('D');
    }
    else {
       System.out.println('F');
    }
  }
}
以上实例编译运行结果如下：

C
这里printGrade方法是一个void类型方法，它不返回值。

一个void方法的调用一定是一个语句。 所以，它被在main方法第三行以语句形式调用。就像任何以分号结束的语句一样。

通过值传递参数
调用一个方法时候需要提供参数，你必须按照参数列表指定的顺序提供。

例如，下面的方法连续n次打印一个消息：

TestVoidMethod.java 文件代码：
public static void nPrintln(String message, int n) {
  for (int i = 0; i < n; i++) {
    System.out.println(message);
  }
}
示例
下面的例子演示按值传递的效果。

该程序创建一个方法，该方法用于交换两个变量。

TestPassByValue.java 文件代码：
public class TestPassByValue {
  public static void main(String[] args) {
    int num1 = 1;
    int num2 = 2;
 
    System.out.println("交换前 num1 的值为：" +
                        num1 + " ，num2 的值为：" + num2);
 
    // 调用swap方法
    swap(num1, num2);
    System.out.println("交换后 num1 的值为：" +
                       num1 + " ，num2 的值为：" + num2);
  }
  /** 交换两个变量的方法 */
  public static void swap(int n1, int n2) {
    System.out.println("\t进入 swap 方法");
    System.out.println("\t\t交换前 n1 的值为：" + n1
                         + "，n2 的值：" + n2);
    // 交换 n1 与 n2的值
    int temp = n1;
    n1 = n2;
    n2 = temp;
 
    System.out.println("\t\t交换后 n1 的值为 " + n1
                         + "，n2 的值：" + n2);
  }
}
以上实例编译运行结果如下：

交换前 num1 的值为：1 ，num2 的值为：2
    进入 swap 方法
        交换前 n1 的值为：1，n2 的值：2
        交换后 n1 的值为 2，n2 的值：1
交换后 num1 的值为：1 ，num2 的值为：2
传递两个参数调用swap方法。有趣的是，方法被调用后，实参的值并没有改变。

方法的重载
上面使用的max方法仅仅适用于int型数据。但如果你想得到两个浮点类型数据的最大值呢？

解决方法是创建另一个有相同名字但参数不同的方法，如下面代码所示：

public static double max(double num1, double num2) {
  if (num1 > num2)
    return num1;
  else
    return num2;
}
如果你调用max方法时传递的是int型参数，则 int型参数的max方法就会被调用；

如果传递的是double型参数，则double类型的max方法体会被调用，这叫做方法重载；

就是说一个类的两个方法拥有相同的名字，但是有不同的参数列表。

Java编译器根据方法签名判断哪个方法应该被调用。

方法重载可以让程序更清晰易读。执行密切相关任务的方法应该使用相同的名字。

重载的方法必须拥有不同的参数列表。你不能仅仅依据修饰符或者返回类型的不同来重载方法。

变量作用域
变量的范围是程序中该变量可以被引用的部分。

方法内定义的变量被称为局部变量。

局部变量的作用范围从声明开始，直到包含它的块结束。

局部变量必须声明才可以使用。

方法的参数范围涵盖整个方法。参数实际上是一个局部变量。

for循环的初始化部分声明的变量，其作用范围在整个循环。

但循环体内声明的变量其适用范围是从它声明到循环体结束。它包含如下所示的变量声明：



你可以在一个方法里，不同的非嵌套块中多次声明一个具有相同的名称局部变量，但你不能在嵌套块内两次声明局部变量。

命令行参数的使用
有时候你希望运行一个程序时候再传递给它消息。这要靠传递命令行参数给main()函数实现。

命令行参数是在执行程序时候紧跟在程序名字后面的信息。

实例
下面的程序打印所有的命令行参数：

CommandLine.java 文件代码：
public class CommandLine {
   public static void main(String args[]){ 
      for(int i=0; i<args.length; i++){
         System.out.println("args[" + i + "]: " + args[i]);
      }
   }
}
如下所示，运行这个程序：

$ javac CommandLine.java 
$ java CommandLine this is a command line 200 -100
args[0]: this
args[1]: is
args[2]: a
args[3]: command
args[4]: line
args[5]: 200
args[6]: -100
构造方法
当一个对象被创建时候，构造方法用来初始化该对象。构造方法和它所在类的名字相同，但构造方法没有返回值。

通常会使用构造方法给一个类的实例变量赋初值，或者执行其它必要的步骤来创建一个完整的对象。

不管你与否自定义构造方法，所有的类都有构造方法，因为Java自动提供了一个默认构造方法，它把所有成员初始化为0。

一旦你定义了自己的构造方法，默认构造方法就会失效。

实例
下面是一个使用构造方法的例子：

// 一个简单的构造函数
class MyClass {
  int x;
 
  // 以下是构造函数
  MyClass() {
    x = 10;
  }
}
你可以像下面这样调用构造方法来初始化一个对象：

ConsDemo.java 文件代码：
public class ConsDemo {
   public static void main(String args[]) {
      MyClass t1 = new MyClass();
      MyClass t2 = new MyClass();
      System.out.println(t1.x + " " + t2.x);
   }
}
大多时候需要一个有参数的构造方法。

实例
下面是一个使用构造方法的例子：

// 一个简单的构造函数
class MyClass {
  int x;
 
  // 以下是构造函数
  MyClass(int i ) {
    x = i;
  }
}
你可以像下面这样调用构造方法来初始化一个对象：

ConsDemo.java 文件代码：
public class ConsDemo {
  public static void main(String args[]) {
    MyClass t1 = new MyClass( 10 );
    MyClass t2 = new MyClass( 20 );
    System.out.println(t1.x + " " + t2.x);
  }
}
运行结果如下：

10 20
可变参数
JDK 1.5 开始，Java支持传递同类型的可变参数给一个方法。

方法的可变参数的声明如下所示：

typeName... parameterName
在方法声明中，在指定参数类型后加一个省略号(...) 。

一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明。

实例
VarargsDemo.java 文件代码：
public class VarargsDemo {
    public static void main(String args[]) {
        // 调用可变参数的方法
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});
    }
 
    public static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }
 
        double result = numbers[0];
 
        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}


finalize() 方法
Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。
例如，你可以使用 finalize() 来确保一个对象打开的文件被关闭了。
在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。

finalize() 一般格式是：
protected void finalize()
{
   // 在这里终结代码
}
关键字 protected 是一个限定符，它确保 finalize() 方法不会被该类以外的代码调用。
当然，Java 的内存回收可以由 JVM 来自动完成。如果你手动使用，则可以使用上面的方法。
```

## Java 流(Stream)、文件(File)和IO
```java



```









