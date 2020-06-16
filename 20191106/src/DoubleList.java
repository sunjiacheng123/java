import com.sun.xml.internal.bind.v2.model.core.ID;

class ListNode{
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继

    public ListNode(int data) {
        this.data = data;
    }
}

public class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head==null){
            head=node;
            last=node;
        }else{
            this.head.prev=node;
            node.next=this.head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if (this.head == null) {
            head=node;
            last=node;
        }else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }
    //打印双向链表
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    //返回删除插入位置的前驱（也可直接返回插入位置，然后利用前驱节点）
    private ListNode searchIndex(int index) {
        ListNode cur=this.head;
        int sum=0;
        while (cur != null) {
            cur=cur.next;
            sum++;
        }
        if (index<0||index > sum) {
            return null;
        }
        cur=this.head;
        while (cur!=null && index - 1 > 0) {
            index--;
            cur=cur.next;
        }
        return cur;
    }

    //任意位置插入一个数字
    public void addIndex(int index,int data){
        if (this.head == null) {
            return ;
        }
        ListNode node=new ListNode(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        ListNode cur=searchIndex(index);
        if (cur != null) {
            node.next=cur.next;
            cur.next.prev=node;
            cur.next=node;
            node.prev=cur;
        }else{
            System.out.println("输入位置不合理");
        }
    }
    //删除第一次出现的key
    public int remove(int key){
        int oldData=-1;
        ListNode cur=this.head;
        while (cur!=null){
            if (cur.data == key && cur==this.head) {
                oldData=cur.data;
                this.head=this.head.next;
                this.head.prev=null;
                return oldData;
            } else if (cur.data == key && cur == this.last) {
                oldData=cur.data;
                this.last=this.last.prev;
                this.last.next=null;
                return oldData;
            }else if (cur.data == key) {
                oldData=cur.data;
                cur.prev.next=cur.next;
                cur.next.prev=cur.prev;
                return oldData;
            }
            cur=cur.next;
        }
        System.out.println("没有要删除的数字");
        return -1;
    }

    //防止内存泄漏
    public void clear(){
        while (this.head != null) {
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.last=null;
    }

}
