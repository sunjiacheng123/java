/*
1.接口的关键字 interface
2.接口当中的方法，全部不能有具体的实现。都是抽象方法--默认的
3.阿里巴巴：接口当中的方法尽量简洁。
4.接口当中的成员变量默认都是public static final的
5.接口不可以被实例化 new
6.一个类可以实现多个接口
7.接口可以继承多个接口

类和接口之间的关系->实现
只要类实现了一个接口，那么接口当中的方法必须重写。

问：抽象类和接口的区别？？？

自定义类型排序需要实现接口Comparable

 */


import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();
        while(true){
            int choice=user.menu();
            user.doOperation(choice,bookList);
        }
    }
    public static User login(){
        System.out.println("请输入名字：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("请输入你的身份：（0:普通用户，1：管理员）");
        int choice=scanner.nextInt();
        if(choice==0){
            return new NormalUser(name);
        }else if(choice==1){
            return new Admin(name);
        }
        return null;
    }
}
