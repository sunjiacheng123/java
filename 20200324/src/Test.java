/*
优先级队列中只能存放可以比较的数据类型
8中基本类型以及其所对应的包装类型都可以直接比较大小，标准库自带的，知道如何比较

注意：用户自定义的类型不能比大小，
原因：标准库怎么知道类对象中哪些成员，如何去比较

标准库： 可以制定一系列规则，只要大家按照规则来，肯定可以实现自定义类型对象的比较
         1.重写equals方法
         注意：自己和自己比较  参数是否为空，两个对象类型是否一致、
         比较：基本类型直接比较，引用类型：调用对应类型的equals方法
         却小：只能进==，不能进行自然次序的比较：大于 小于
         2.实现Comparable<类型>接口类--->重写compareTo--->left-right
         优点：可以按照自然次序进行比较
         缺点：对于代码的侵入性比较强--->需要修改源代码
                如果类是用户自己实现的，可以使用  如果类不是自己实现的就不行了
         3.使用比较器Comparator<类>：1.需要用户自己定义一个新类，该类必须要实现Comparator<比较类>
                                     2.在比较的类中：compare重写
            使用：先创建一个比较器的对象，然后让比较器对象调用conpare方法来完成对应类型的比较
            优势：对代码的侵入性小，不需要修改源代码
问题：
*/

class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}

public class Test {

    public static void main(String[] args) {
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");
        //System.out.println(c1 > c2); // 编译报错
        System.out.println(c1 == c2); // 编译成功 ----> 打印false，因为c1和c2指向的是不同对象
        //System.out.println(c1 < c2); // 编译报错
        System.out.println(c1 == c3);
        //Java中引用类型的变量不能直接按照 > 或者 < 方式进行比较。 那为什么==可以比较？
        //因为：对于用户实现自定义类型，都默认继承自Object类，而Object类中提供了equal方法，而==默认情况下调
        //用的就是equal方法，但是该方法的比较规则是：没有比较引用变量引用对象的内容，而是直接比较引用变量的地
        //址，但有些情况下该种比较就不符合题意。
        System.out.println(c1 == c4);//false，比较的是地址

    }
}

