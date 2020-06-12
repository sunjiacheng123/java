/*
/：除数一定不能为0，否则会报告异常（运行时异常）
异常：
	运行时异常
	编译时异常
当程序出现异常时，会立即停止，不会继续进行
处理异常：try catch
%；取模  它不同于c语言中的，它可以小数取模
++；尽量使用后置++
关系运算符的表达式返回值都是 boolean 类型.
逻辑运算符的操作数(操作数往往是关系运算符的结果)和返回值都是 boolean .
&&;左右两边必须是boolean类型
！；！表达式   表达式只能是布尔类型
& 和 | 如果左右表达式为 boolean 的时候, 也表示逻辑运算. 但是和 && 以及 || 相比, 它们不支持短路求值.
& | ~ ^：针对二进制运算
<<:相当于乘法  
>>:相当于除法 (看符号位，1补1，0补0)
>>>:无符号右移 （不管符号位左侧直接补0）
<<<:没有
表达式1 ? 表达式2 : 表达式3:唯一的三目运算符
单行注释：// 注释内容（用的最多）
多行注释：/* 注释内容*/（不推荐）
文档注释： /** 文档注释 **/（类前，方法前使用）
/*
if（布尔表达式）｛
｝
switch(整数|枚举|字符|字符串)｛
｝
面试：不能做switch 的参数有哪些？
      long double  float  booolean  
while(布尔表达式){

}
break:结束所有循环	  
continue：	  
*/

public class test{
	public static void main(String[] args){
		int a=10;
		int b=20;
		System.out.println(a == b);//false
		System.out.println(a != b); //ture
		System.out.println(a < b);
		System.out.println(a > b);
		System.out.println(a <= b); 
		System.out.println(a >= b);
		System.out.println(a++ && b++);//error  a++不是boolean类型
		System.out.println(5<a<20);//error 5<a为ture ，ture<20 ????
		//System.out.println(a/b);
		System.out.println(!a<b);//error
		System.out.println(10 > 20 && 10 / 0 == 0);//false  后面不执行
		while(a){
		}//error
		
		//1!+2!+3!+4!+5!
		int num=5;
		int sum=0;
		while (num>0){
			int i=1;
			int ret=1;
			while (i<=num){
			ret=i*ret;
			i++;
			}
			sum+=ret;
			num--;
		}
		
		
		
	}
}