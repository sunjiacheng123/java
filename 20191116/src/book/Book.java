package book;

public class Book {
    public int id;
    public String name;
    public String author;
    public int price;
    public int time;
    public String type;
    //是否借出
    public boolean isBorrowed;

    public Book(int id,String name, String author, int price, int time,String type) {
        this.id=id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.time=time;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", time=" + time +
                ", type='" + type + '\'' +
                "  "+((isBorrowed==true)?"已经被借出":"未被借出")+
                '}';
    }

//    @java.lang.Override
//    public java.lang.String toString() {
//        return "Book{" +
//                "name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                ", price=" + price +
//                ", type='" + type + '\'' +
//
//                //", isBorrowed=" + isBorrowed +
//                '}';
//    }
}
