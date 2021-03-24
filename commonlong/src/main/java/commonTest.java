import org.apache.commons.lang3.*;

public class commonTest {
    public static void main(String[] args) {
        Integer[] integers=new Integer[]{1,2,3,null};
        Integer[] integers1=new Integer[]{1,2,3};
        //相同个数、相同顺序的数组hashCode会是一样的
        System.out.println(ArrayUtils.hashCode(integers1));
        System.out.println(ArrayUtils.hashCode(integers));
        System.out.println(ObjectUtils.notEqual(integers1,integers));//比较

        String[] strings=ArrayUtils.toStringArray(integers,"1");//将数组中的null转换成想转换的，不然会报错

        char ch='2';
        int i= CharUtils.toIntValue(ch);//数字字符转成对应的数字
        System.out.println(i);

        String str= ClassPathUtils.toFullyQualifiedName(StringUtils.class,"123");//处理类路径，返回包名+resourceName拼接的字符串
        System.out.println(str);

        System.out.println(ClassUtils.isPrimitiveOrWrapper(int.class));//检测是不是包装类型或者基本类型
        System.out.println(ClassUtils.isPrimitiveWrapper(String.class));//检测是不是包装类型
        System.out.println(Integer.class.isPrimitive());//检测是不是基本类型
        System.out.println(Object.class.isPrimitive());//false

        String s=RandomStringUtils.random(10);
        System.out.println(s);

        String s1=RandomStringUtils.random(3,'a','b','c','d','e');//在指定范围内随机,限定字符串长度为3
        System.out.println(s1);

        String s2= RandomStringUtils.randomAscii(10);//随机生成10个ascll
        System.out.println(s2);

        //不是5到10内随机,而是随机一个长度的数字,5-10位数字
        String randomNumeric = RandomStringUtils.randomNumeric(5,10);
        System.out.println(randomNumeric);//
    }
}
