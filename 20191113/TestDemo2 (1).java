/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-13
 * Time: 20:11
 */
class B {
    public B() {
        func();
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class D extends B {
    private int num = 1;
    @Override
    public void func() {
        System.out.println("D.func() " + num);
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        D d = new D();
        d.func();
    }
}
