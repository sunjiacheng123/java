package opertion;

import book.BookList;

public class FindOperation implements IOperation{
        @Override
    public void work(BookList bookList) {
        System.out.println("FindOperation");
        System.out.println("输入需要查找书籍的书号");
        int id=scanner.nextInt();
        System.out.println("输入需要查找书籍的名称");
        String name = scanner.next();

        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i=0;
        for(;i<bookList.getSize();i++){
            if(name.equals(bookList.getBook(i).name)||id==bookList.getBook(i).id){
                System.out.println(bookList.getBook(i));
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("没有这本书");
            return;
        }else {
            System.out.println("查找书籍成功!");
        }

    }
}
