import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;
import sun.security.util.Length;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortLambda {
    public static void main1(String[] args) {
        String[] str={"abc","sda","iorud","sdkjau","qeiw","igu"};
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //lambda输出
        List<String> list=Arrays.asList(str);
        list.forEach(s -> System.out.println(s));
    }

    public static void main(String[] args) {
        //lambda排序
        String[] str={"abc","sda","iorud","sdkjau","qeiw","igu"};
        Comparator<String> co=(String s1,String s2)-> (s1.compareTo(s2));
        Arrays.sort(str,co);
        List<String> list=Arrays.asList(str);
        list.forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        //或者是这种
        Arrays.sort(str,(String s1,String s2)->(s1.compareTo(s2)));
        list.forEach(s -> System.out.println(s));

        System.out.println("---------------------");
        //使用匿名内部类根据str的长度排序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Arrays.sort(str,(String s1,String s2)->(s1.length()-s2.length()));
        list.forEach(s -> System.out.println(s));

        System.out.println("------------------------");
        //使用匿名内部类排序 str, 根据最后一个字母
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(o1.length()-1)-o2.charAt(o2.length()-1);
            }
        });
        Arrays.sort(str,(String s1,String s2) -> (s1.charAt(s1.length()-1)-s2.charAt(s2.length()-1)));
        list.forEach(s -> System.out.println(s));
    }

}
