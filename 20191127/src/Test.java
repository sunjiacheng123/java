/*


反射：java自省-->指的是程序运行过程中, 获取/修改某个对象的详细信息(类型信息, 属性信息等), 相当于让一个对象更好的 "认清
自己" .
破坏封装，访问一个类内部的 private 成员.
常量：编译的时候已经被处理
 */
public class Test {
    public static void main6(String[] args) {
        char[] array={'a','b','c'};
        //1.字符数组变字符串
        String str3=new String(array);
        //偏移量--》从0开始
        String str2=new String(array,1,2);
        System.out.println(str2);
        //2.字符数组变字符串
        String str4=String.copyValueOf(array);



        //判断字符串是否全由数字组成
        String str="12345a6";
        char[] ch=str.toCharArray();//字符串变为字符数组
        int i=0;
        for(i=0;i<ch.length;i++) {
            if (ch[i] > '9' || ch[i] < '0') {
                System.out.println("不全由数字组成");
                break;
            }
        }
        if(i>=ch.length){
            System.out.println("全由数字组成");
        }
    }

    public static void main5(String[] args) {
        String str="abcdef";
        String str1=new String("abcdef").intern();
        //intern
        //1.常量池当中存在，返回常量池当中字符串对象的地址。
        //2.常量池当中不存在，那么在常量池中生成该对象的引用。
        System.out.println(str==str1);//true
        String str2="hello";
        //提取一个子串：从1号下标开始提取子串
        //相当于创建了一个新的对象
        str2="h"+str.substring(1);//str="hello"
        //也可以通过反射修改
    }

    public static void main(String[] args) {
        String str="abcdefg";//直接赋值
        String str1="abcd";
        System.out.println(str.compareTo(str1));
        //比较str和str2的值（String中已经实现了compareTo接口）
    }

    public static void main3(String[] args) {
        String str="abcdef";//直接赋值
        String str2=str;
        str="hello";//str指向新的地址
        System.out.println(str2);//输出hello
    }

    public static void main2(String[] args) {
        String str="abc"+"def"+360;//产生1个常量“abcdef360”
        //变量，运行时才知道存放的是多少
        int a=360;
    }

    public static void main1(String[] args) {
        String str="abcdef";//abcdef为常量,在常量池
        String str1="abc"+"def";//编译期就变成了abcdef
        String str5="abc"+new String("def");//产生了两个对象
        //abc在常量池 ，new了一个内存，str5指向value和abc所新组成的一块内存
        System.out.println(str==str5);//false,比较引用，看存放的地址是否相等
        // 等号两边为简单类型则比较里面的内容是否相同
        System.out.println(str.equals(str1));//比较内容是否相同
        System.out.println(str.equals("abcdef"));
        //为防止空指针异常写成
        System.out.println(("abcdef").equals(str));
    }

    public static void main0(String[] args) {
        String str="abcdef";//直接复制  在常量池内开辟一块内存空间
        String str1="abcdef";//再次直接复制，不会开辟内存空间，常量池中有指定内容，直接进行引用
        System.out.println(str==str1);//true
    }
}
