/*
方法
HelloWorld :大驼峰  类名
*/
class HelloWorld {
	
}

public class Test {
	
	public static void main(String[] args){
		/*
		   CPU是以4个字节为单位 进行内存的读写数据
		   所有  不够4个字节的数据 都要先提升为int
		   
		   byte   short 
		*/
		
		
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a+b);
		
		System.out.println(c);
		
		/*
		int a = 10;//4
		long b = 12L;//8
		//a先会提升为 long 然后再进行运算
		int c = (int)(a+b);
		long d = a+b;
		*/
		//double c = 12.5;//8
		//boolean bool = true;
		
		
		//short s1 = 10;
		//char c1 = (char)s1;
		
		//char c2 = 99;
		//short s2 = (short)c2;
		
		//bool = (boolean)a;
		//a = bool;
		
		//b = a; ->小类型-》大类型  隐式类型转换
		//a = (int)b;//error -》 大类型-》小类型 我们需要强制类型转换-》(类型)
		
		//c = a;
		//a = c;error
		
	}
	
	
	public static void main3(String[] args){
		/*
		C:const   来定义一个常量
		Java：final  可以不在定义的同时进行初始化
		   但是一旦被初始化，就不能被改变了。
		
		常量：运行期间不可以被改变的
		变量：运行期间可以改变的
		
		final 不仅可以变量  还可以修饰：函数 类 接口
		......
		*/
		final int a;
		a = 20;
		System.out.println(a);
		
	}
	
	public static void main2(String[] args){
		
		int a_1 = 10;
		int a$2 = 20;
		int ___a = 99;
		System.out.println(a_1);
		System.out.println(a$2);
		System.out.println(___a);
		
		int maxNum = 10;//小驼峰
		int age = 99;
		
		//数字不能开头
		
		/*
		{
			int a = 10;//局部变量
		}
		
		System.out.println(a);
		*/
	}
	
	
	public static void main1(String[] args){
		/*
			C :   char    1   128 - 127  0 - 255
		    Java: char    2   0-65535   没有负数
			      字符类型
		
		
		char c = 99;
		char c2 = 'A';
		char c3 = '高';
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		//float f = 22.5f;
		//System.out.println(f);
		*/
		
		//字节类型   1个字节   
		//Java 当中的字节类型 对标的是C语言里面的char
		//-128 - 127   
		
		/*
		byte b = -128;
		//System.out.println(b);
		//System.out.println(Byte.MAX_VALUE);
		//System.out.println(Byte.MIN_VALUE);
		//byte c = 20;
		
		//'\u0000'  ---- '\uFFFF' 
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MIN_VALUE);
		
		//System.out.println(c);
		*/
		
		/*
		  短整型：short    2     32767 ---  -32768   
		
		short s = 99;
		
		System.out.println(s);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		*/
		
		/*
		  布尔类型：
		     boolean   只有两种值 true  false
			 占几个字节？    标准 并没有规定
			 boolean的字节大小
		
		
		boolean b = true;
		boolean b1 = false;
		System.out.println(b);
		System.out.println(b1);
		
		*/
		
		/*
		字符串类型：并没有说是：有\0。 
		*****
		    String 
		
		
		String str = "hello";
		String str2 = "bit";
		String str3 = str+str2;//拼接  strcat()
		System.out.println(str3);
		
		String str4 = "hello" + "Java13!";
		System.out.println(str4);
		
		int a = 10;
		int b = 20;
		System.out.println("a = " + a + ","+"b = " + b);
		
		
		String str5 = "Javav13";
		//System.out.println(*(str5+1)); error
		//charAt(index);0号下标开始
		System.out.println(str5.charAt(1));
		//返回指定字符第一次出现的字符串内的索引
		System.out.println(str5.indexOf('v'));
		*/
	}
}
