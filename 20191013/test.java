/*

for(表达式1;表达式2;表达式3){} 表达式2为布尔类型
system.in:输入
system.out:输出
编译时期的异常，必须处理之后，才能使用。
注意：
1.在java中没有什么方法需要声明
2.只有按值传递 （引用———>低配的指针）

重载：
	1.函数名相同
	2.参数列表不同（类型和个数）
	3.返回值类型不做要求
	4.必须在同一个类当中或者在继承关系上
	


*/

import java.util.Scanner
//导入包  util 工具类

public class test{
	public static void main(String[] args){
		int[] array={10,20};
		swap(array);
		System.out.println(array[0]);
		System.out.println(array[1]);
	}
	
	public static void swap(int[] array2){//array2：引用 保存地址
		int tmp=array2[0];
		array2[0]=array2[1];
		array2[1]=tmp;
	} 
	
	public static void main1(String[] args){
		Scanner cool=new Scanner(System.in);
		System.out.println("请输入你的姓名；");
		String name =cool.nextLine();
		String name =cool.next();
		//next():遇到空格就结束
		System.out.println(msg); // 输出一个字符串, 带换行
		System.out.print(msg); // 输出一个字符串, 不带换行
		System.out.printf(format, msg); // 格式化输出（与c里相同）
		cool.close;//关闭之后就不能使用。
		//ctr+c  正常的停止程序
		//ctr+z	 
		for(int i=0; ;i++){
			System.out.println(i);
		}//死循环
	}
}