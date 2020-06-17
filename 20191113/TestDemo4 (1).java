/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-13
 * Time: 21:03
 */

/**
 * 1、包含抽象方法的类 叫做抽象类   abstract
 * 2、抽象类 不能被实例化 new
 * 3、抽象类当中可以有抽象方法 也可以有非抽象方法或者
 * 成员变量
 * 4、抽象类  就是为了继承的
 * 5、抽象类被 继承之后 一定要重写抽象方法
 * 6、抽象类A如果继承了抽象类B，呢么抽象类A可以选择重写或者
 * 不重写抽象类B当中的方法。
 */
abstract class Shape2 {
    //abstract:抽象方法
    public abstract void draw();
}

abstract class B3 extends Shape2 {
    @Override
    public void draw() {
        System.out.println("抽象类重写了，那么继承之后不需要" +
                "重写");
    }
}

class B4 extends B3{
    /*@Override
    public void draw() {
        System.out.println("必须重写");
    }*/
}

class B2 extends Shape2 {
    @Override
    public void draw() {
        System.out.println("B2");
    }
}

class Rect2 extends Shape2 {
    @Override
    public void draw() {
        //super.draw();
        System.out.println("♦");
    }
}
class Cycle2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Triangle2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("三角形");
    }
}
public class TestDemo4 {

    public static void drawMap(Shape2 shape2) {
        shape2.draw();
    }

    public static void main(String[] args) {
        Shape2 shape2 = new Rect2();
        drawMap(shape2);
        Cycle2 cycle2 = new Cycle2();
        drawMap(cycle2);
        Triangle2 triangle2 = new Triangle2();
        drawMap(triangle2);
    }
}
