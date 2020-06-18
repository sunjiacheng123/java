import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 9:42
 */
interface IFlying {
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}
class Animal {
    public String name;
    public Animal(String name) {
        this.name = name;
    }
}

class Cat extends Animal implements IRunning{
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name+"run()");
    }
}
class Bird extends Animal implements IFlying,IRunning {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+"fly");
    }

    @Override
    public void run() {
        System.out.println(this.name+"run");
    }
}
//扩展能力很强
class Robot implements IRunning{
    @Override
    public void run() {
        System.out.println("机器人跑步");
    }
}

public class TestDemo3 {
    public static void walk(IRunning running) {
        System.out.println("我带着伙伴去散步");
        running.run();
    }
    public static void swimming(ISwimming iSwimming) {
        System.out.println("我带着伙伴去游泳");
        iSwimming.swim();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("小花");
        walk(cat);
        walk(new Robot());
    }
}
