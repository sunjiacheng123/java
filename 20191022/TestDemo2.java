/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-10-22
 * Time: 18:41
 */
/*class Person {
    public String name;//属性  成员变量 实例成员变量
    public int age;
    //static 静态成员变量  方法区
    public static int count = 10;
    public static final int SIZE = 30;//方法区
    //final修饰之后 放在哪个内存区域不一定
    public final int SIZE2 = 20;//实例成员变量

    public static void func1() {
        System.out.println("func1()");
    }

    //行为  方法   成员方法  实例成员方法
    public void eat() {
        int b = 10;
        System.out.println( name + "吃饭！");
    }
    public void sleep() {
        System.out.println( name +"睡觉！");
    }

    public void show() {
        System.out.println("name: "+ name +" age: "+age);
    }
}*/
/*class Person {
    public String name;//属性  成员变量 实例成员变量
    public int age;
    public static int count;

    public void func1() {
        System.out.println("count:" + count);
    }

    public static void func2(Person per) {
        //error
        System.out.println("name:" + per.name);
        count = 99;
        System.out.println("count:" + count);
    }

    public void eat() {
        int b = 10;
        System.out.println( name + "吃饭！");
    }
    public void sleep() {
        System.out.println( name +"睡觉！");
    }
}*/
/**
 * 1、初始化方式  提供一系列的get  set 方法
 * 2、构造方法
 *     方法名和类名一样的
 *     单例设计模式-》
 */


class Person {
    private String name;//属性  成员变量 实例成员变量
    private int age;

    //不带有参数的构造方法
    public Person() {
        this("曹操");//必须放到第一行
        //this("孙悟空",1000);//必须放到第一行
        System.out.println("Person()!");
    }
    public Person(String name) {
        this.name = name;
        System.out.println("Person(String)!");
    }
    public Person(String name,int age) {
        this.age = age;
        this.name = name;
        System.out.println("Person(String,int)!");
    }

    //alt+insert(f12)  fn+esc
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void func(){
        //System.out.println("name "+ this.name);error
    }

    public void eat() {
        this.sleep();
        System.out.println("吃饭！");
    }
    private void sleep() {
        System.out.println("睡觉！");
    }
    public void show() {
        System.out.println(name+" "+age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
    }

    public static void main7(String[] args) {
        //会调用不带有参数的构造方法
        Person person = new Person();
        System.out.println(person.getName());
        //person.sleep();
        person.eat();
       /* Person person2 = new Person("bit");
        System.out.println(person2.getName());
        Person person3 = new Person("高博",18);
        System.out.println(person3.getName());
        System.out.println(person3.getAge());*/
    }

    public static void main6(String[] args) {
        Person person = new Person();
//        person.name;
//        person.age;
        person.show();
        person.setName("bit");
        System.out.println(person.getName());
        person.setAge(10);
        System.out.println(person.getAge());
        person.show();

    }


    public  void func() {
        System.out.println("TestDemo2.func()");
    }

    public static void main5(String[] args) {
        //func();
        TestDemo2 testDemo2 = new TestDemo2();
        testDemo2.func();

        Person person1 = new Person();
        //person1.func1();
        //空指针异常
       // System.out.println(person1.name.length());
    }

    /*public static void main4(String[] args) {
        Person person1 = new Person();
        person1.count++;
        System.out.println(person1.count);//1

        Person person2 = new Person();
        person2.count++;
        System.out.println(person2.count);//2
    }*/

    public static void main3(String[] args) {
        Person person = new Person();
        //System.out.println(person.name);
        //System.out.println(person.age);
    }

    /*public static void main2(String[] args) {
        Person person = new Person();
        System.out.println(Person.count);
        System.out.println(Person.SIZE);
        System.out.println(person.SIZE2);
        //person.func1();//引用去访问
        Person.func1();//类名.方法
    }*/


    /*public static void main1(String[] args) {
        //实例化一个对象  new
        Person person = new Person();
        person.name = "张飞";
        person.age = 99;
        person.eat();
        //person.show();
        Person person2 = new Person();
        person2.name = "关羽";
        person2.age = 999;
        person2.eat();
        Person person3 = new Person();
        person3.name = "高博";
        person3.age = 18;
        person3.eat();
    }*/
}
