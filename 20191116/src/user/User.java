package user;

import book.BookList;
import opertion.IOperation;

public abstract class User{
    protected String name;
    protected IOperation[] operations;
    public abstract int menu();

    public void doOperation(int choice, BookList bookList){
        operations[choice].work(bookList);
    }
}
