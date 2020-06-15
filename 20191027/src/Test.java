/*
代码块：
    本地代码块(方法内部)；
    实例代码块（类内方法外）；初始化类的实例数据成员，静态数据成员也可被初始化
    静态代码块；用来初始化静态的数据成员
    1.实例代码块优先于构造方法。
    2.静态代码块优先于实例代码块。
    3.同级的，与顺序有关。
    4.静态的东西只被初始化一层

匿名对象：匿名对象只能在创建对象时使用 new Person（）.sleep（）； 只能使用一层

时间复杂度：执行算法所用的时间    代码中，基本语句的执行次数：循环，递归
1.找到幂数最高的，保留最高阶，系数不要。例：2N+10-》N

空间复杂度：执行算法所用的空间  算是变量的个数

算法的效率：
    以时间换取空间
    以空间换取时间





 */

import javax.sound.midi.Soundbank;

//链表测试类
public class Test {


//两个有序链表的按data值从小到大连接
    public static ListNade mergeTwoLists(ListNade headA,ListNade headB) {
        ListNade node=new ListNade(-1);
        ListNade tmp=node;
        while (headA!=null&&headB!=null){
            if (headA.data < headB.data) {
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;//
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA!=null){
            tmp.next=headA;
        }
        if (headB != null) {
            tmp.next=headB;
        }
        return node.next;
//        ListNade node=new ListNade(-1);
//        ListNade tmp=node;
//        while (headA!=null&&headB!=null){
//            if(headA.data<headB.data){
//                tmp.next=headA;
//                headA=headA.next;
//                tmp=tmp.next;
//            }else{
//                tmp.next=headB;
//                headB=headB.next;
//                tmp=tmp.next;
//            }
//        }
//        if(headA!=null){
//            tmp.next=headA;
//        }
//        if (headB!=null){
//            tmp.next=headB;
//        }
//        return node.next;
    }
    //两个链表的交点
    public static ListNade getIntersectionNode(ListNade headA,ListNade headB){
        if(headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNade pL = headA;
        //永远指向最短的单链表
        ListNade pS = headB;
        int lenA = 0;
        int lenB = 0;
        //分别求长度
        while (pL!=null){
            pL=pL.next;
            lenA++;
        }
        while (pS!=null){
            pS=pS.next;
            lenB++;
        }
        //求长度的差值
        int len = lenA-lenB;
        //如果是负数-》pL = headB;  pS = headA
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }else {
            pL=headA;
            pS=headB;
        }
        //只需要让pL走len步就好了
        while(len>0){
            pL=pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        //一直走 走到next值相同时 就是交点
        while (pL!=pS && pL!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS && pL!=null){
            return pS;
        }
        return null;
    }

    public static void main(String[] args) {
        MySignalList mySignalList=new MySignalList();
        mySignalList.addFirst(5);
        mySignalList.addFirst(4);
        mySignalList.addFirst(3);
        mySignalList.addFirst(2);
        mySignalList.addFirst(1);

        MySignalList mySignalList1=new MySignalList();
        mySignalList1.addFirst(10);
        mySignalList1.addFirst(9);
        mySignalList1.addFirst(8);
        mySignalList1.addFirst(7);
        mySignalList1.addFirst(6);
        ListNade node=mergeTwoLists(mySignalList.head,mySignalList1.head);
        mySignalList.display1(node);
//        mySignalList.head.next.next=mySignalList1.head.next;
//        ListNade nade=getIntersectionNode(mySignalList.head,mySignalList1.head);
//        System.out.println(nade.data);
//        mySignalList.creatHuan();
//        System.out.println(mySignalList.detectCycle().data);
//        ListNade nade=mySignalList.deleteDuplication();
//        mySignalList.display1(nade);
//        mySignalList.display();
//        System.out.println(mySignalList.detectCycle().data);
//        mySignalList.display();
//        ListNade node=mySignalList.partition(4);
//        mySignalList.display1(node);
//        mySignalList.addIndex(1,5);
//        mySignalList.display();
//        if(mySignalList.contains(6)){
//            System.out.println("1");
//        }else{
//            System.out.println("0");
//        }
//        mySignalList.removeAllKey(5);
//        mySignalList.display();
//        //mySignalList.remove(2);
//        //mySignalList.display();
//
//
//        ListNade head=mySignalList.reverseList();
//        mySignalList.display1(head);
        //mySignalList.display2();
    }
}
