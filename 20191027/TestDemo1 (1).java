/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-10-27
 * Time: 9:20
 */
class Person{
    private String name;
    private int age;
    public static int count = 10;

    //静态代码块-》初始化 静态的数据成员
    static {
        count = 9999999;
        //this.name = "chang";
        System.out.println("static{}");
    }

    //实例代码块 --》 初始化类的实例数据成员
    {
        this.name = "caocao";
        this.age = 99;
        //count = 8888;
        System.out.println("instance{}");
    }

    public Person() {
        System.out.println("Person()");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String,int)");
    }

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

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public static void func() {
        System.out.println("static:func()");
    }

}
public class TestDemo1 {

    public static void main(String[] args) {
        new Person().sleep();
        new Person().sleep();
    }
    public static void main1(String[] args) {
        Person person = new Person();
        System.out.println("================");
        Person person2 = new Person();
        System.out.println("================");
        Person person3 = new Person();
    }
}
