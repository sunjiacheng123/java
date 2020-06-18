package opertion;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍");
        System.out.println("请输入图书书号");
        int id=scanner.nextInt();
        System.out.println("请输入图书的名字");
        String name = scanner.next();
        System.out.println("请输入图书的作者");
        String author = scanner.next();
        System.out.println("请输入图书的价格");

        int price = scanner.nextInt();
        System.out.println("请输入出版时间");
        int time=scanner.nextInt();
        System.out.println("请输入图书的类型");
        String type = scanner.next();
        Book book = new Book(id,name,author,price,time,type);
        //没有考虑满的情况
        bookList.books[bookList.getSize()]=book;
        bookList.setSize(bookList.getSize()+1);
        System.out.println("添加成功");
    }
}
