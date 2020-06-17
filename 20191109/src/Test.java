/*
包：文件
包的命名：小写字母并且采用公司网站-->倒叙
访问权限：public private   pritected  包访问权限
包访问权限:只能访问同一个包内的

继承：为了代码的复用
继承表示 is - a 语义
java只能继承一个类
子类/派生类extends父类/基类/超类
子类继承了除构造方法外的所有东西
super：调用父类的构造方法（必须放在子类构造方法的第一行）
如果要构造子类，必须先构造父类
super（与this相似）：
    super.父类方法
    super.父类成员
    super（）  父类构造方法
基类只能访问自己的成员或方法

protected访问权限：
    1.同一个包。
    2.不同包中的子类。
大多用于封装

final：final所修饰的类为密封类
密封类：不能被继承
final int a ->常量
final所修饰的不能被修改

组合：表示 has - a 语义

 */



class Address {
    public String domic;
    public int floor;

    public Address(String domic,int floor) {
        this.domic = domic;
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "Address{" +
                "domic='" + domic + '\'' +
                ", floor=" + floor +
                '}';
    }
}

class Student{
    public String name;
    public int age;
    public Address address;//组合

    public Student(String name, int age,
                   Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address"+ address+
                '}';
    }
}
public class Test {

//    public class TestDemo2 {
//        public static void main(String[] args) {
//            Address address = new Address("7",1);
//            Student student = new Student
//                    ("曹操",18,address);
//            System.out.println(student);
//
//        }
//    }
    public static void main(String[] args) {
            Address address = new Address("7",1);
            Student student = new Student("曹操",18,address);
            System.out.println(student);
        }
}
