package opertion;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("ReturnOperation");
        System.out.println("输入需要归还书籍的名称");
        String name = scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("没有这本书");
            return;
        }
        Book book =bookList.getBook(i);
        if(book.isBorrowed){
            book.isBorrowed=false;
            System.out.println("归还成功");
        }else{
            System.out.println("未被借出");
        }
    }
}
