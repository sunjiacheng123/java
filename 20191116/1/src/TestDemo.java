/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 9:13
 */
/*interface Shape {

}*/
/**
 * 类和接口之间的而关系-》实现
 *  * 只要普通类实现这个接口，那么接口当中的方法
 *  * 必须重写
 */
class Rect implements IShape{
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}
class Cycle implements IShape {
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}
public class TestDemo {

    public static void drawMap(IShape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        //向上转型
        IShape iShape = new Rect();
        IShape iShape2 = new Cycle();
        drawMap(iShape);
        drawMap(iShape2);
    }
}
