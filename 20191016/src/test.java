/*
psvm:main函数
sout：输出语句
调试：
    1.打断点
    2.点击七星瓢虫
    3.箭头
注释：ctrl+/
      ctrl+shift+/
 */

/*
递归的本质：将大问题化解为小问题的过程
递归：
    1.调用函数本事
    2.有一个趋近于终止的条件

 */
import java.util.Scanner;

public class test {
    public static void fab(){
        fab();
    }//栈溢出异常：
    //因为：函数/方法调用全部都发生在栈上
    public static int sum(int n){
        //1+2+3+4...+n
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }

    public static void num(int n){
        //按顺序打印一个数字的每一位
        if(n>9){
            num(n/10);
        }
        System.out.println(n%10);
    }

    public static int  fac(int n){
        //返回组成他数字的和
        int sum=0;
        if(n<10){
            return n;
        }
        return n%10+fac(n/10);
    }

    public static int sum2(int n){
        //求斐波那契数中第n个数
        if(n==2||n==1){
            return 1;
        }
        return sum2(n-1)+sum2(n-2);
    }
    public static int sum1(int n){
        int sum=0;
        if(n<=2){
            sum=1;
        }else{
            int ch1=1;
            int ch2=1;
            for(int i=3;i<=n;i++){
                sum=ch1+ch2;
                ch1=ch2;
                ch2=sum;
            }
        }
        return sum;
    }

    public static int tiao(int n){
        //青蛙跳台阶
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        return tiao(n-1)+tiao(n-2);
    }

    public static void main(String[] args) {
        int n=5;
         //System.out.println(sum(5));
         //num(1234);
//        int a=fac(1729);
//        System.out.println(a);
         System.out.println(tiao(5));
         System.out.println(sum1(6));
         System.out.println(sum2(6));
         }
    }
