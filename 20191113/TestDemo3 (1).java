/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-13
 * Time: 20:44
 */
class Shape {
    public void draw() {

    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        //super.draw();
        System.out.println("♦");
    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("三角形");
    }
}

//类的调用者     类的实现着
public class TestDemo3 {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Triangle triangle = new Triangle();
        drawMap(cycle);
        drawMap(rect);
        drawMap(triangle);
    }
}
