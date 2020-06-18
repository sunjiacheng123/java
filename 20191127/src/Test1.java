/*
@Deprecated:在源码中出现，表示此代码过时了
何时用char？何时用byte？
String自己实现了compareto接口了
 */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test1 {



    public static void main4(String[] args) {
        StringBuilder ssb= new StringBuilder("abcdef");
        //StringBuilder在使用append拼接时不会产生新的对象；
        System.out.println(ssb);
        ssb.append("java13");//拼接  abcdefjava13
        System.out.println(ssb);
    }

    public static void main3(String[] args) {
        //提取
        String str = "ABCDEF";
        String string = str.substring(2);//提取从2号小标开始的所有字符
        String string1 = str.substring(2,3);//[2,3)从2-3
        //KMP算法-》查找子串在主串当中的位置（了解）
        System.out.println(string);

        String str2="   abc   def   ";
        str2=str2.trim();//删除当前字符串前后的空格 ，中间的不删除
        System.out.println(str2);

        String str3="abcdef";
        str3=str3.toUpperCase();//字符串转大写
        //tolowercase  转小写
        System.out.println(str3);

        String str1 = "ABCDEF";
        str = str.concat("HELLO");//在字符串后面拼接
        System.out.println(str1);

        String str4 = null;//空引用
        String str5 = "";//空串
        if(str5.isEmpty()) {//判断是否为空串
            System.out.println("abcd");
        }
    }

    public static void main2(String[] args) {
        //替换
        String str = "abcadab";
        str = str.replace("ab","ly");//替换所有指定字符串
        str = str.replaceFirst("ab","py");//替换第一次出现的字符串
        System.out.println(str);
        //拆分
        String str1 = "abc-ad-ab";
        String[] strings = str1.split("-");
        String[] strings1 = str1.split("-",2);//限定最多分2组
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings1));

        String str2 = "192*168*1*1";
        String[] strings2 = str2.split("\\*");//\*正则表达式
        System.out.println(Arrays.toString(strings2));

        String str3 = "abc=def ght=gb";
        String[] strings3 = str3.split(" ");
        //System.out.println(strings3[0]);
        System.out.println(Arrays.toString(strings3));
        for (String s : strings3  ) {
            String[] ss = s.split("=");
            System.out.println(Arrays.toString(ss));
        }
    }

    public static void main1(String[] args) throws UnsupportedEncodingException {
        byte[] bytes={97,98,99,100};
        String string=new String(bytes,1,2);
        System.out.println(string);
        String str2 = "DE";
        //字节串转换为字节数组
        byte[] bytes1 = str2.getBytes();
        System.out.println(Arrays.toString(bytes1));
        String str3 = "高";
        //汉字以字节数组形式输出
        byte[] bytes2 = str3.getBytes("utf8");
        System.out.println(Arrays.toString(bytes2));
        //比较
        String str4 = "ABCDEFG";
        System.out.println(str2.equals(str4));//比较内容
        System.out.println(str2.equalsIgnoreCase(str4));//忽略大小写比较

        System.out.println(str2.compareTo(str4));//str2   和 str4进行比较   返回整形数字
        //查找
        System.out.println(str4.contains(str2));//字符串4是否包含字符串2
        System.out.println(str4.indexOf(str2));//字符串4包含字符串2，则返回下标,找不到则返回-1   效率更高
        System.out.println(str4.indexOf(str2,2));//从哪个位置开始找
        System.out.println(str4.lastIndexOf(str2,5));//fromindex:从指定位置由后往前找，没有fromindex则默认从最后往前找

        System.out.println(str4.startsWith("CD"));//判断是否以CD开头
        System.out.println(str4.startsWith("CD",2));//从指定位置开始，判断是否已CD开始
        System.out.println(str4.endsWith("DE"));//判断是否以DE结尾
    }

}
