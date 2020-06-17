import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:  组合->a part of  has-a    继承-》is-a
 * User: GAOBO
 * Date: 2019-11-13
 * Time: 16:27
 */
//继承：-》为了代码的复用
class Animal {
    public String name;
    public int age;
    public Animal() {
        eat();
    }
    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
        //System.out.println("Animal(String,int)");
    }
    public  void eat() {
        System.out.println("Animal::eat()");
    }
}
//父类 超类 基类   Cat:子类  派生类
class Cat extends Animal{
    public String sex;
    public Cat() {
    }
    public Cat(String name,int age,String sex) {
        super(name,age);//显示调用父类的构造方法
        this.sex = sex;
        //System.out.println("Cat(String,int,String)");
    }
    public void jump() {
        System.out.println(this.name+"跳");
    }
    public void eat() {
        System.out.println("Cat::eat()");
    }
}
class Bird extends  Animal{
    public String yumao;
    public void fly() {
        System.out.println("fly()");
    }
}
public class TestDemo {

    public static void main(String[] args) {
        Cat cat = new Cat();
        //cat.eat();
    }


    public static void main5(String[] args) {
        Animal animal = new Bird();
        //animal.eat();
        if(animal instanceof Cat ) {
            Cat cat = (Cat)animal ;
            cat.jump();
        }
        /*Bird bird =  (Bird)animal;
        bird.fly();*/



    }

    public static void func(Animal animal) {
        //animal.eat();
    }
    public static Cat func2() {
        Cat cat = new Cat();
        return cat;
    }
    public static void main4(String[] args) {
        Animal animal = func2();
        //Cat cat = new Cat();
        //func(cat);
    }


    public static void main3(String[] args) {
        Animal animal = new Cat();
        animal.eat();
        //animal.jump();  父类只能调用父类自己的方法
    }

    public static void main2(String[] args) {
        //Animal animal = new Animal("动物",12);
        //Cat cat = new Cat("小花",12,"woman");
        //cat.eat();
        //Animal animal = new
          //      Cat("小花",12,"woman");//向上转型
        //父类引用  子类对象 -》向上转型
        //animal.eat();
    }


    public static void main1(String[] args) {
        Cat cat = new Cat("小花",12,"woman");
        System.out.println();
        Cat cat2 = new Cat("小名",12,"woman");

        //cat.jump();
        //cat.eat();
    }
}
