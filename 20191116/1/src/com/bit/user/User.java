package com.bit.user;

import com.bit.book.BookList;
import com.bit.operation.IOperation;

/**
 * @ProjectName JavaBit
 * @ClassName User
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:27
 * @Version 1.0
 **/
public abstract class User{
    protected String name;
    protected  IOperation[] operations;

    public abstract int menu();

    public void doOperation(int choice, BookList bookList){

    }
}
