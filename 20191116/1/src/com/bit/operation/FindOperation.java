package com.bit.operation;
import com.bit.book.BookList;

/**
 * @ProjectName JavaBit
 * @ClassName FindOperation
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:32
 * @Version 1.0
 **/
public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("FindOperation");
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("没有这么书");
            return;
        }else {
            System.out.println("查找书籍成功!");
        }

    }
}
