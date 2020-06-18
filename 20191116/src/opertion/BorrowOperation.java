package opertion;

import book.Book;
import book.BookList;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("BorrowOperation");
        System.out.println("输入需要借阅书籍的书号");
        int id=scanner.nextInt();
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)||id==bookList.getBook(i).id){
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("没有这么书");
            return;
        }
        //2、他是否被借出   false  可以借
        Book book =bookList.getBook(i);
        if(book.isBorrowed){
            System.out.println("已经被借出");
        }else{
            book.isBorrowed=true;
            System.out.println("借书成功");
        }
    }
}