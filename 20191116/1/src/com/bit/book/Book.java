package com.bit.book;

/**
 * @ProjectName JavaBit
 * @ClassName Book
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:27
 * @Version 1.0
 **/
public class Book {
    public String name;
    public String author;
    public int price;
    public String type;
    //是否借出
    public boolean isBorrowed;

    public Book(String name, String author, int price, String type, boolean isBorrowed) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }
    public Book(String name, String author, int price, String type) {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((isBorrowed==true)?"已经被借出":"未被借出")+
                //", isBorrowed=" + isBorrowed +
                '}';
    }
}
