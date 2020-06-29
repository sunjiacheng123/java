/*

 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueText {

    public static  void TestPriori(){
        PriorityQueue<Integer> p1=new PriorityQueue<>();
        //注意插入的元素一定要能比大小，而且不能插入null对象
        //插入是会自动进行扩容
        //插入的时间复杂度O（logN）
        //插入失败时，返回false或者抛出异常
        //插入元素期间，优先级队列中的元素会进行调整，首元素一定是最小的
        p1.offer(4);
        p1.offer(1);
        p1.offer(3);
        p1.offer(0);
        p1.offer(5);
        p1.offer(2);
        //peek();取优先级队列中的第一个元素
        System.out.println(p1.peek());
        //删除优先级队列中的第一个元素
        //剩余元素会自动进行调整-->将剩余元素中最小的元素调到首元素为宗旨
        //时间复杂度：O(logN)
        p1.poll();
        System.out.println(p1.peek());
        p1.poll();
        System.out.println(p1.peek());
        p1.clear();
        if(p1.isEmpty()){
            System.out.println("优先级队列已经为空");
        }
    }
    public static void main(String[] args) {
        TestPriori();
    }

    public static void main1(String[] args) {
        //1.构造一个空的优先级队列:空的优先级队列，但是底层已经有11个默认空间
        PriorityQueue<Integer> p1=new PriorityQueue<>();

        //2.按照指定容量来进行构造
        //如果知道优先级队列中大概要放多少个元素，最好使用该种方式进行构造
        //不要使用空的构造方式构造，因为在插入元素时，需要不断扩容而影响程序的效率
        PriorityQueue<Integer> p2=new PriorityQueue<>(20);

        //3.可以用一个集合来直接构造优先级队列，将来就会将集合中的元素放到优先级队列
        List <Integer> l=new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        PriorityQueue<Integer> p3=new PriorityQueue<>(l);
        System.out.println(p3.size());

    }
}
