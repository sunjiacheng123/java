import org.omg.CORBA.PUBLIC_MEMBER;

import javax.sound.midi.Soundbank;
import javax.xml.soap.Node;

class ListNade{
    public int data;
    public ListNade next;

    public ListNade(int data){
        this.data=data;
        this.next=null;
    }
}//节点类

class MySignalList {
    public ListNade head;
    //构造方法
    public MySignalList(){

    }

    //头插法
    public void addFirst(int data){
        //1.判断是不是第一次插入
        ListNade node=new ListNade(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNade node=new ListNade(data);
        if(this.head==null) {
            this.head = node;
        }else{
            ListNade cur=this.head;
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    public void display(){
        ListNade cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //查找是否包含关键字key在单链表中
    public boolean contains(int key){
        ListNade cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //得到单链表的长度
    public int getLength(){
        ListNade cur=this.head;
        int sum=0;
        while (cur!=null){
            sum++;
            cur=cur.next;
        }
        return sum;
    }

    private ListNade searchIndex(int index) {
        ListNade cur = this.head;
        int count=0;
        while (index>1){
            cur=cur.next;
            //count++;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        ListNade node=new ListNade(data);
        if(index <  0 | index > getLength()) {
            System.out.println("index不合法！");
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        ListNade cur=searchIndex(index);
        node.next=cur.next;
        cur.next=node;
        return true;
    }

    private ListNade searchPrev(int key) {
        ListNade cur=this.head;
        while(cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空
        ListNade prev = searchPrev(key);
        if(prev==null){
            System.out.println("没有key这个节点");
            return ;
        }
        ListNade del=prev.next;
        //2、删除节点
        prev.next=del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNade pre=this.head;
        ListNade cur=pre.next;
        while (cur!=null){
            if(pre.next.data==key){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    //逆置单链表
    //练习

    public ListNade reverseList1() {
        ListNade cur=this.head;
        ListNade pre=null;
        ListNade newhead=null;
        while (cur!=null){
            ListNade curNext=cur.next;
            if(curNext==null){
                newhead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newhead;
    }

    public ListNade reverseList(){
        ListNade pre=null;
        ListNade newHead=null;
        ListNade cur =this.head;
        while (cur!=null){
            ListNade curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
            //curNext=cur.next;
        }
        return newHead;
    }
//找倒数第k个节点
    public ListNade findKth(int k){
        if(this.head!=null){
            ListNade cur=this.head;
            ListNade pre=this.head;
            if(k==0){
                return null;
            }
            while (k-1>0){
                if(pre.next!=null){
                    k--;
                    pre=pre.next;
                }else{
                    System.out.println("没有这个节点");
                }
            }
            while (pre.next!=null){
                pre=pre.next;
                cur=cur.next;
            }
            return cur;
        }
        return null;
    }
//    public void display2(){
//        ListNade cur=reverseList();
//        while(cur!=null){
//            System.out.print(cur.data+" ");
//            cur=cur.next;
//        }
//        System.out.println();
//    }

    public void display1(ListNade newHead){
        ListNade cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //找单链表的中间节点
    public ListNade middlenade(){
        ListNade fast=this.head;
        ListNade slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }


//小于一个数的节点在前面，大的在后面
    public ListNade partition(int x) {
        ListNade cur = this.head;
        ListNade beforeStart = null;
        ListNade beforeEnd = null;
        ListNade afterStart = null;
        ListNade afterEnd = null;
        while (cur != null) {
            //cur.data < x
            if(cur.data < x) {
                //第一次插入
                if(beforeStart==null) {
                    beforeStart=cur;
                    beforeEnd=beforeStart;
                }else {
                    beforeEnd.next=cur;
                    beforeEnd=cur;
                }
            }else {
                //第一次插入
                if(afterStart == null) {
                    afterStart=cur;
                    afterEnd=afterStart;
                }else {
                    afterEnd.next=cur;
                    afterEnd=cur;
                }
            }
            cur=cur.next;
        }
        if(beforeEnd==null){
            return afterStart;
        }else{
            if(afterStart==null){
                return beforeStart;
            }else{
                beforeEnd.next=afterStart;
                afterEnd.next=null;
                return beforeStart;
            }
        }
    }

    //删除重复的节点（重复节点连在一起时）
    public ListNade deleteDuplication() {
        ListNade node = new ListNade(-1);
        ListNade cur = this.head;
        ListNade tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                //1、循环
                while (cur.next != null && cur.data==cur.next.data){
                    cur=cur.next;
                }
                //2、退出循环 cur要多走一步
                cur=cur.next;
                //
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        node=node.next;
        tmp.next=null;
        return node;
    }

    //判断是不是回文
    public boolean chkPalindrome() {
        ListNade fast = this.head;
        ListNade slow = this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNade p = slow.next;
        while (p != null) {
            ListNade pNext = p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while (this.head!=slow){
            if(this.head.data==slow.data){
                //偶数个
                if(head.next==slow){
                    return true;
                }
                this.head=this.head.next;
                slow=slow.next;
            }else{
                return false;
            }
        }
        return true;
    }
    //创建环
    public void creatHuan(){
        ListNade cur=this.head;
        if(cur!=null){
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=this.head.next;
        }
    }

    //判断是否存在环
    public boolean hasCycle(){
        ListNade fast=this.head;
        ListNade slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //找环的接入点
    //快慢相遇的地方，让一个指向头节点，一起走，再次相遇的地方就是接入点
    public ListNade detectCycle(){
        ListNade fast=this.head;
        ListNade slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while(fast!=null&&slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //求环的长度，快慢第一次相遇点，让一个继续走，直到再次次相遇（设变量count，循环++）
    public int listLenth(){
        ListNade fast=this.head;
        ListNade slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return 0;
        }
        int count=1;
        //slow==fast
        slow=slow.next;
        while(slow!=fast){
            slow=slow.next;
            count++;
        }
        return count;
    }




}//单链表
