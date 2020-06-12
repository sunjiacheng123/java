/*
一次编译，到处运行
内置类型（简单类型）：
int    4	0
char   2	"\u0000"
short  2	0
long   8	0
double 8	0.0d
float  4	0.0f
byte   1 	0	
boolean   		false
引用类型：
String  数组  类  接口...

注意：
 byte
到底什么是引用？


编码 解码 ASCLL(c) Unicode(java)
java:GBK
文本：UTF-8
类名：大驼峰 HelloWorld
变量名：小驼峰 arrAa

*/



public class Test{
	public static void main(String[] args){
		/*
		c；char  1   128-127 0-255
		java; cahr  2  0-65535  没有负数  ‘\u0000--\uFFFF’ (16进制)
		java 中的字节类型对标的是C语言里面的char
		byte  1  -128-127
		short 2 32767-32768
		boolean  ture false  并没有规定字节大小
		String
		c:const  定义一个常量
		java ：final   可以不再定义的同时进行初始化，但是一旦被初始化，就不能被改变了
		常量：运行时不可以被改变
		变量：运行时可以改变的
		final：不仅可以修饰变量，还可以修饰函数、类、接口。
		
		*/	
		final int a;
		byte b=a+b;//a+b 为int型
		boolean d=ture;
		byte a=10;
		byte b=130;//超过最大值   编译不过
		char c=12;
		char c2='A';
		char c3='高';
		System.out.println();
	}
}