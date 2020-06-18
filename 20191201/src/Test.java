
/*
运行时异常：空指针异常，算数异常...
编译时期异常：受查异常  clone

建议return不要放在finaly中，会一直try或catch中的return语句

1.自定义异常的时候需要自己定义一个类时实现exception
2.在抛出的时候，需要自己进行throws
3.相当于受查异常，需要处理异常

内部类：
实例内部类
静态内部类
匿名内部类
本地内部类

 */

import java.util.Scanner;

class OutClass{
    public  int data=10;
    public static  int data1=20;
    //实例内部类--》相当于实例方法
    /*
    1.实例内部类不能有静态的数据成员
    2.如何拿到内部类的对象
    3.问：实例内部类是否拥有外层类对象/是否有额外开销？
     */
    class inclass{
        public  int data1=100;

        public inclass() {
            System.out.println();
        }
        public void func(){
            System.out.println(data1+"data1");
        }
    }
    /*
    静态内部类
    1.OutClass.inoclass i=new OutClass.inoclass();
    2.静态内部类不能直接访问外部内部类的非静态数据成员，但是可以间接访问
     */
    static  class inoclass{
        public  int data1=999;
        public static int data2=888;
        public inoclass(){

        }
        public void fun(){
            System.out.println(OutClass.data1);//外部类静态变量
            System.out.println();
        }

    }
}

class MyThread{
    public  void  fun(){
        System.out.println("456");
    }
}

public class Test {

    public static void main(String[] args) {
        OutClass o=new OutClass();
        OutClass.inclass in=o.new inclass();
        //拿到实例内部类
        in.func();

        OutClass.inoclass i=new OutClass.inoclass();
        //拿到静态内部类

        ///匿名内部类
        new MyThread(){
            @Override
            //重写funfangfa
            public void fun() {
                System.out.println("123");
            }
        }.fun();
    }

    public static  int div(int a,int b) throws ArithmeticException{
        //声明异常，以便main中处理捕获
         if(b == 0) {
            throw new ArithmeticException();
            //主动抛出异常
        }
        return a/b;
    }

    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=null;
        System.out.println(arr.length);
        //出现空指针异常，after不会被打印
        System.out.println("after");
//        int a
        try {

            int a=scanner.nextInt();
            System.out.println(arr.length);
            System.out.println("before");
            //捕获异常后，before不会被打印
            System.out.println();
           }
//      catch (Exception e){
//            //捕获所有异常
//        }
        catch (NullPointerException e){
            //即将被捕获的异常
            e.printStackTrace();
            System.out.println("异常捕获");
        }finally {//异常的出口
            //资源的关闭--》文件打开--》组员关闭
            scanner.close();
            System.out.println("finally");
            //永远会被执行
        }
        System.out.println("after");
         //  只要捕获异常代码后，就会被打印
    }
}
