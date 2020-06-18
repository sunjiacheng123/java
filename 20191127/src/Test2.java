import java.util.Scanner;

public class Test2 {



    public static String reverse(String str) {
        char[] value = str.toCharArray();
        int left = 0;
        int right = value.length-1;
        while (left < right) {
            char tmp = value[left];
            value[left] = value[right];
            value[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(value);
    }

    public static void main4(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse(str));
    }

    public static void main3(String[] args) {
        String str = "abc";
        StringBuffer sb = new StringBuffer();//String-->StringBuffer
        sb.append(str);//String-->StringBuffer
        System.out.println(sb);

    }

    public static void main2(String[] args) {
        StringBuilder sb = new StringBuilder("ab");
        sb.append("gaobo");//用于单线程
        StringBuffer sb2 = new StringBuffer("cd");
        sb2.append("Java13");//synchronized:同步处理  线程安全   在多线程下使用
        sb.reverse();//StringBuilder独有的逆置方法
        System.out.println(sb);//
        System.out.println(sb2);
    }


    public static void main(String[] args) {

        //String str = "ab";
        StringBuilder sb = new StringBuilder("ab");
        for (int i = 0; i < 1000; i++) {
            //str = str+i;循环中每次都要new一个StringBuilder对象
            sb.append(i);//每次循环不需要new对象
        }
        //System.out.println(sb);

        //1.Stringde +的凭借底层被优化为StringBuilder
        //2.append（）；
        //3.toString();
        String str = "abcdef";
        str = str + "gh";
        //System.out.println(str);
//        StringBuilder sb = new StringBuilder();
//        sb.append("abcdef");
//        sb.append("gh");
//        String str = sb.toString();
//        System.out.println(str);

        //拼接是最好用StringBuilder
        StringBuilder ssb= new StringBuilder("abcdef");
        //StringBuilder在使用append拼接时不会产生新的对象；
        char[] a={'m'};
        System.out.println(ssb);
        ssb.append("asdaf");//拼接  abcdefjava13
        //ssb.append(a);//可以拼接字符数组类型
        System.out.println(ssb);
    }

}
