package com.bit.operation;

import com.bit.book.BookList;

/**
 * @ClassName ExitOperation
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:34
 * @Version 1.0
 **/
public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("byebye");
        System.exit(0);
    }
}
