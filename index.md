###java全部是==>>类,所有[属性+方法]全写在类里面,完全面向对象.

### java修饰符
[撇开java的几个修饰符，java语法写起来也蛮简洁的=>变量+函数+类]

0.一个A.java源文件的名字必须和其中的[有且仅有一个的]public class A{}名字相同,
  A.java中可以有其他非public的class,

1.类的修饰符(没有private,没有static,final的类不准被继承)

[public/abstract/final] class A {}

2.类里面属性的修饰符(final的属性值不准再改变)

[public/private/default/protected] [static] [final] int a = 1;

3.类里面方法的修饰符(final的方法不准被子类重写，方法的()和{}都不能省略,方法内部也不能定义方法)

[public/private/default/protected] [static] [final] int/void a(String a,int b){ }

4.类里面的构造方法的修饰符(没有返回值,也不写void,正常只写public,)

[public/private/default/protected] A(int a,float b){ }

5.类里面方法里面的属性(没有权限修饰符，没有static)

[final] int a = 1;

###java 数组+集合类

1.数组([数组里只能放相同数据类型]，写法上是int a[] = new int[],只要有方括号则表明了是数组，)

int a = 1; 由单个普通变量写法引申出多个变量集合写法==>>即数组的写法,

int a[] = new int[n]/int[] a = new int[n]; n为数组元素个数，

int a[]/int[] a = {1,2,3,4}; 数组声明顺带赋值,

2.集合类 ArrayList[动态数组] + HashMap[哈希表]{先new个集合类对象出来，再往里放东西}

ArrayList a = new ArrayList();

a.Add('first element in list');

HashMap b = new HashMap();

b.put("语文" , 80.0);   


###[java教程：C语言中文网](http://www.weixueyuan.net/java/rumen/)

