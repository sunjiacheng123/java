package com.bit.book;

/**
 * @ProjectName JavaBit
 * @ClassName BookList
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:27
 * @Version 1.0
 **/

/**
 * @author
 */
public class BookList {
    public Book[] books=new Book[10];
    /**
     * 有效数据个数
     */
    public int size;
    public BookList(){
        books[0]=new Book("三国演义","罗贯中",13,"小说");
        books[1]=new Book("红楼梦","曹雪芹",16,"小说");
        books[2]=new Book("西游记","施耐庵",20,"小说");
        this.size=3;
    }
    public void setBooks(int pos,Book book)
    {
        this.books[pos]=book;
    }
    public Book getBook(int pos){
        return books[pos];
    }
    public int getSize()
    {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
