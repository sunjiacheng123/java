/*
底层结构：
arraylist:动态类型的顺序表
linkedlist:双向链表？是否有头结点
常用接口：
Arraylist 和linkedlist的区别？
连续空间     链式空间
A：支持随机访问，不适用任意位置插入和删除O（n）,插入期间可能需要扩容，Arraylist扩容时空间利用率可能会低，存储+大量的访问，迭代器取下一个元素：索引++
L：不支持随机访问，O(1),插入期间不需要扩容，空间利用率可能低，大量任意位置元素插入和删除，next指针域

两种特殊的线性结构：栈和队列


 */


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        char[] a={0,0};
        Arrays.sort(a);
        System.out.println(a[0]);
        String string= "sdd";
       // string.charAt(3);
        System.out.println(string.length());
        System.out.println(string.charAt(string.length()-1));
    }
}
