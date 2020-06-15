/*
类和对象：
目的：什么事类？什么是对象？
问：oop语言的三大特征？继承，封装，多态
oop：面向对象程序设计语言   obj-oriented-p....

面向过程注重的是过程，在整个过程中所涉及的行为，就是功能。
面向对象注重的是对象，也就是参与过程所涉及到的主体。是通过逻辑将一个个功能实现连接起来
一个类可以产生多个对象

成员变量：1.实例数据成员  2.静态数据成员
        如果没有赋值，那么他的默认值就是自己所对应的0值
        引用类型--》null     数组  类  string
        简单类型--》0   char ‘\u0000'  boolean=false

static;静态成员变量放在方法区，属于类，只存在一份
静态成员变量的访问：类名.属性（通过对象的引用去访问，但是不建议.）
静态成员方法的调用:类名.方法、
所有被static修饰的成员,方法，他的调用或访问都只需要通过类名.就可以做到
也就是说：所有static多修饰的不管方法，成员都不依赖于对象
在静态方法内部不能访问非静态的数据成员？？
原因：静态的方法不依赖于对象，对象是否产生，并不影响调用静态方法，而非静态的数据成员依赖于对象。

为什么main函数是static所修饰的？？？
如果不是静态的，那么main函数的调用需要对象

final：修饰后 放在哪个区域不一定
通过对象的引用去访问

private:私有的
1.初始化方式  提供一系列的get set方式（alt+insert）
2.构造方法 ： 实例化一个对象--》构造方法   new Person（）；
  如果在实现类的时候，没有写构造方法，那么编译器会自动生成一个不带有参数的构造方法。
  但是：如果你自己写了一个不带有参数的构造方法，那么，编译器不会为你自动生成一个不带有参数的构造方法
规则：
  （1）方法名称必须与类名称相同
  （2）构造方法没有返回值类型声明
  （3）每一个类中一定至少存在一个构造方法
构造方法也能发生重载
3.一个对象的产生分为几步？？？
  ①为对象分配内存
  ②调用合适的构造方法



问：this代表什么？？
当前对象的引用
静态方法里面不能使用this
this的使用：
1.this.成员方法
2.this.成员变量
3.this（）；调用另外一个构造方法，必须放在第一行

 */
class Person{
    public String name;//属性  成员变量  实例成员变量

    //行为  方法 成员方法 实例成员方法
    public void eat(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //
    @Override  //注解
    // 重写父类Object中的toString
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test {


    public static void main(String[] args) {
        //实例化一个对象
        Person person=new Person();
        person.eat();
    }

    //补：
    //可变参数编程
    public static  int sum(int... a){
        int ret=0;
        for (int x:a) {
            ret+=x;
        }
        return ret;
    }
    public static void main0(String[] args) {
        System.out.println(sum(10,20,30,40,50));
    }
}
