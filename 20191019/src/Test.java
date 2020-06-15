/*
数组：相同类型数组的集合，内存是连续的
定义：int [] array1={1,2,3,4,5};   int[] array2=new int[]{1,2,3,4,5};
      int[] array3=new int[5];
      new：产生一个对象
引用：用来存放对象的地址
注意：1.当数组越界之后：
        异常：java.lang.ArrayIndexOutOfBoundsException
      2.数组名.length：数组长度。 length不是方法是一个属性。
      3.foreach
      for(表达式1：表达式2)｛｝。表达式1：数组中的变量名。表达式2：数组名
      4.当定义好数组之后没有初始化，默认值为0.
        数组当中如果是引用类型就是null
      5.
java当中数组的内存分析：
JVM内存划分;java虚拟机站：局部变量
            本地方法栈：native方法：底层由c/c++实现，特点：快
            程序计数器：指令
            堆：对象。new关键字
            方法区： 静态变量，类的信息
            常量池：作用-》存放字符串常量的。string str=“hello”；
            （在JDK1.7之前，常量池在方法区当中
              在JDK1.7之后，常量池被挪到堆当中）
Native 方法:由c++实现的，再由java调用
浅拷贝：如果是两个引用同时指向一个对象，那么通过一个引用修改当前对象的值后，那么另外一个引用也会受到影响

Arrays.copyOfRange拷贝部分
Arrays.equals(arr,arr1);
Arrays.fill(arr,9);全部填充为9
Arrays.fill(arr,2,5,9);2号下标到5号下标填充为9
Arrays.sort(arr);对数组进行排序
问：底层是什么排序？？？
 */


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Test {


    public static void main(String[] args) {
        //二维数组

//        Arrays.fill(arr,9);
//        Arrays.fill(arr,2,5,9);
//        Arrays.equals(arr,arr1);
        int[] arr={1,2,6,2,7,58,9,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//打印
    }


    public static int bianrySearch(int[] array,int key,int left,int right){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if(array[mid]==key){
            return mid;
        }else if(array[mid]>key){
            return bianrySearch(array,key,left,mid-1);
        }else{
            return bianrySearch(array,key,mid+1,right);
        }
    }

    public static void main6(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(bianrySearch(arr,5,0,8));
        System.out.println(Arrays.binarySearch(arr,5));
    }


    public static void mac(int[] arr){
        int tmp=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>tmp){
                tmp=arr[i];
            }
        }
        System.out.println(tmp);
    }

    public static void mac1(int[] arr){
        int tmp = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]<tmp){
                tmp=arr[i];
            }
        }
        System.out.println(tmp);
    }

    public static void mac2(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        sum=sum/arr.length;
        System.out.println(sum);
    }

    public static void mac3(int[] arr){
        int sum=0;
        int j=arr.length-1;
        for (int i = 0; i < arr.length/2; i++) {

                sum=arr[i];
                arr[i]=arr[j];
                arr[j]=sum;
                j--;
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    public static void mac4(int[] arr){

        int i=0;
        int j=arr.length-1;
        while(j!=i){
            if(arr[i]%2==1&&arr[j]%2==1){//前奇后奇
                i++;
            }else if(arr[i]%2==0&&arr[j]%2==1){//前偶后奇
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;j--;
            }else if(arr[i]%2==1&&arr[j]%2==0){//前奇后偶
                i++;j--;
            }else{
                j--;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }

    public static void main5(String[] args) {
        int[] arr={8,5,58,3,7};
        mac(arr);
        mac1(arr);
       mac2(arr);
        mac3(arr);
        mac4(arr);
    }


    public static void main4(String[] args) {
        int[] array={1,2,3,4,5};
        int[] array1=new int[array.length];
        //数组的拷贝
        System.arraycopy(array,0,array1,0,array.length);
        array1=Arrays.copyOf(array,array.length);
        //两者的区别和联系：
        // Arrays.copyOf内部调用了System.arraycopy
        //System.arraycopy被native所修饰的方法，是c++实现的（速度快）
        array1=array.clone();
    }

    //toString
    public static String toString(int[] array){
        String str="[";
        for (int i = 0; i < array.length; i++) {
            str+=array[i];//警告：后期讲解
            if(i<array.length-1){
                str+=",";
            }
        }
        str+="]";
        return str;
    }

    public static void main3(String[]args){
        int[] array=new int[]{1,2,3,4,5};
        System.out.println(toString(array));
    }

    public static int[] func(int[] array){
        for (int i = 0; i < array.length; i++) {
        array[i]=array[i]*2;
    }
        return array;
}

    public static void main2(String[] args) {
        int[] array=new int[]{1,2,3,4,5};
        int[] ret=func(array);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]+" ");
        }
        System.out.println(Arrays.toString(array));//将数组以字符串形式进行输出。
        //Arrays：java当中操作数组的工具类。
    }

    public static void main1(String[] args) {
        int [] array1={1,2,3,4,5};
        int[] array2=new int[]{1,2,3,4,5};
        int[] array3=new int[5];
        System.out.println(array1[12]);//越界
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        for (int x:array1 ) {//不能够用下标访问
            System.out.println(x);
        }
    }
}
