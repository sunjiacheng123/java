/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-10-22
 * Time: 18:33
 */
public class TestDemo1 {

    public static int sum (int a,int b) {
        return a+b;
    }
    public static int sum (int a,int b,int c) {
        return a+b+c;
    }

    public static int sum (int a,int b,int c,int d) {
        return a+b+c+d;
    }
    //可变参数编程
    public static int sum(int... a) {
        int ret = 0;
        for (int x:a) {
            ret += x;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(sum(10,20));
        System.out.println(sum(10,20,30));
        System.out.println(sum(10,20,30,40));
        System.out.println(sum(10,20,30,40,50));
        System.out.println(sum(10,20,30,40,50,60));
        System.out.println(sum(10,20,30,40,50,60,70));
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(array));
        System.out.println(sum(new int[]{1,2,3,4,5}));
        //匿名数组
    }
}
