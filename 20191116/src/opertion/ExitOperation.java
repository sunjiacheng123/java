package opertion;

import book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("byebye");
        System.exit(0);
    }
}

