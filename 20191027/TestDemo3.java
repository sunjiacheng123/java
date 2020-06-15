/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-10-27
 * Time: 9:54
 */
class MyValue {
    public int num;
}
public class TestDemo3 {

    public static void swap2(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.num;
        myValue1.num = myValue2.num;
        myValue2.num = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.num = 10;
        MyValue myValue2 = new MyValue();
        myValue2.num = 20;
        System.out.println(myValue1.num+" "+myValue2.num);
        swap2(myValue1,myValue2);
        System.out.println(myValue1.num+" "+myValue2.num);
    }

    public static void swap(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }


    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a+" "+b);
        swap(a,b);
        System.out.println(a+" "+b);
    }
}
