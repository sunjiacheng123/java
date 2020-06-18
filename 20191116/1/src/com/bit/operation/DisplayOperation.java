package com.bit.operation;

import com.bit.book.BookList;

/**
 * @ProjectName JavaBit
 * @ClassName DisplayOperation
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:33
 * @Version 1.0
 **/
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("DisplayOperation");
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
