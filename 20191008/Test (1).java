
/**

文档注释  类前   或者 方法前面
类的信息：
作者
日期
描述：
......
// 这是傻逼策划非要加的 .....
*/

public class Test {
	
	
	
	public static void main3(String[] args) {
		//break  : 结束所有循环
		//continue :结束本趟循环
		int num = 1;
		while(num <= 10) {
			if(num % 3 != 0) {
				num++;
				continue;
			}
			System.out.println(num);
			num++;
		}
	}
	
	public static void main2(String[] args) {
		
		int num = 5;
		int ret = 1;
		int i = 1;
		int sum = 0;
		//1 2 3 4 5
		while(i <= num) {
			int j = 1;
			//1! 1  2!2   3! 6   4! 24   5!  120
			ret = 1;
			while(j <= i) {
				ret *= j;
				j++;
			}
			sum += ret;
			i++;
		}
		System.out.println("sum = " + sum);
	}
	public static void main1(String[] args) {
		//1!+2!+3!+4!+5!
		
		int num = 5;
		int ret = 1;
		int i = 1;
		while(i <= num) {
			ret *= i;
			i++;
		}
		System.out.println("ret = " + ret);
		
		/*
		int a = 1;
		while(true) {
			System.out.println("1");
		}
		
		//long day = 1L;
		//boolean day = true;
		String str = "hello";
		switch(str) {
			case "hello":
				System.out.println("1");
				break;
			case "bit":
				System.out.println("2");
				break;
			
			default:
				System.out.println("error");
				break;
		}
		
		   不能做Switch的参数有哪些？
		   long  double  float   boolean
		   
		   String  char  枚举   
		*/
		
		/*
		int x = 10;
		int y = 10;
		if (x == 10){
			if (y == 10) {
				System.out.println("aaa");
			}else {
				System.out.println("bbb");
			}
		}
			
		
		
		int year = 2020;
		
		if(year%100!=0 && year%4 == 0 || year %400 == 0) {
			System.out.println("闰年");
		}else {
			System.out.println("不是闰年");
		}
		
		
		
		int num = 9;
		if(num % 2 == 0) {
			System.out.println("偶数");
		}else {
			System.out.println("奇数");
		}
		
		
		int a = 20;
		if(a > 10) {
			System.out.println("a > 10");
		}else if(a == 10) {
			System.out.println("a == 10");
		}else {
			System.out.println("a < 10");
		}
		*/
		//int a = 0xf;
		//System.out.printf("%x\n", ~a);
		
		
		//System.out.println(10 > 20 && 10 / 0 == 0); // 打印 false
		
		//System.out.println(10 < 20 || 10 / 0 == 0);
		
		
		
		
		/*
		int a = 10;
		int b = 20;
		
		System.out.println(a & b);
		int a = 10;
		int b = 20;
		int c = 30;
		
		//System.out.println(b < a || b < c);
		//System.out.println(!a < b);
		
		
		int a = 10;
		int b = 20;
		System.out.println(a == b);//false
		System.out.println(a <= b);//true
		System.out.println(a >= b);//false
		System.out.println(a != b);//true
		*/
		//System.out.println(5 < a < 20);//
		//5 < a   true       true < 20 ???
		
		/*
		//Java   后置++；  循环 GO  
		int a = 10;
		int b = a++;
		System.out.println(b);
		
		
		int a = 10;
		int b = 20;
		System.out.println(10.0%1.5);//1.0
		
		
		try {
			System.out.println(1/0);
		}catch(ArithmeticException e){
			//System.out.println();
		}
		*/
	}
}

