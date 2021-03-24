import org.apache.commons.lang3.StringUtils;

public class StringTest {
    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("  "));//不为空  false
        System.out.println(StringUtils.isEmpty("sad "));

        System.out.println("*************************");
        System.out.println(StringUtils.isAnyEmpty("","sda"));//参数有一个空  就返回true
        System.out.println(StringUtils.isAnyEmpty(null,"sda"));
        System.out.println(StringUtils.isAnyEmpty("  ","sda"));//false
        System.out.println(StringUtils.isNoneEmpty("  ","sda"));//结果为isAnyEmpty取反
        System.out.println(StringUtils.isNoneEmpty("",""));//全为空 才返回false

        System.out.println("**************************");
        System.out.println(StringUtils.isBlank(""));//判断字符对象是不是空字符串相当于深度的isEmpty
        System.out.println(StringUtils.isBlank("  "));//为空 true  与isempty不一样
        System.out.println(StringUtils.isAnyBlank("  ","sda"));//true

        System.out.println(StringUtils.trimToEmpty("   "));//返回”“
        System.out.println(StringUtils.trimToNull("   "));//返回null

        System.out.println("*************************");
        System.out.println(StringUtils.ordinalIndexOf("asasassssa","ad",5));//字符串在另一个字符串中出现第几次的位置,没有则返回-1
        System.out.println(StringUtils.ordinalIndexOf("asasassssa","",1));//空永远返回0
        System.out.println(StringUtils.lastOrdinalIndexOf("asasassssa","a",1));//从最后开始的字符串出现第一次的位置


        System.out.println(StringUtils.containsAny("sada","s","w"));//是否包含后面数组中的任意对象，返回true,存在一个就返回true
        System.out.println(StringUtils.containsAny("sada",""));

        System.out.println("**************************");
        System.out.println(StringUtils.left("asadaa",5));//从左边开始截取指定个数
        System.out.println(StringUtils.right("asadaa",2));  //从右边开始截取指定个数
        System.out.println(StringUtils.mid("asadaa",2,2));//从中间的指定位置开始截取  指定个数

        //特定字符串连接数组
        System.out.println( StringUtils.join(new String[]{"a","a","d"},';'));//a;a;d
        System.out.println( StringUtils.join(new String[]{null,"","d"},';'));//;;d

        System.out.println("***********************");
        System.out.println(StringUtils.deleteWhitespace("  das dsa  "));//删除空格 比trim更强劲
        System.out.println(StringUtils.rightPad("sd",5,"s"));//右边自动用指定的字符补全至指定长度
        System.out.println(StringUtils.leftPad("sd",5,"s"));//左边补齐
        System.out.println(StringUtils.center("sd",5));//把主体放在中间，两边自动用空串补齐

        System.out.println("***********************");
        System.out.println(StringUtils.capitalize("sd"));//首字母大写
        System.out.println(StringUtils.upperCase("sd"));//全大写
        System.out.println(StringUtils.swapCase("sd"));//大小写互换
        System.out.println(StringUtils.reverse("ssdsdw"));//字符串反转
    }
}
