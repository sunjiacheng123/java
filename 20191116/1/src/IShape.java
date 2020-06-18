/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 9:22
 */

/**
 * 1、接口的关键字 interface
 * 2、接口当中的方法 全部不能有具体的实现。
 *    都是抽象方法---默认的public abstract
 * 3、阿里巴巴：接口当中的方法尽量简洁
 * 4、接口当中的成员变量public static final
 * 5、IShape接口是不可以被实例化的 new
 * 6、implements A,B,C,D,E.....
 * 7、接口和接口是继承
 */
interface A {
    void funcA();
}
interface T {
    void funcT();
}
//此时B就包含了A和T的功能
interface B extends A,T{
    void funcB();
}
class C implements B{
    @Override
    public void funcA() {
    }
    @Override
    public void funcB() {
    }
    @Override
    public void funcT() {
    }
}

public interface IShape {
    //int size = 10;
    void draw();
}
