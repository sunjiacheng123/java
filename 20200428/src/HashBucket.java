/*
哈希桶：
 */
public class HashBucket {
    public static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
        }
    }
    //哈希桶中的成员数据
    Node[] arr;
    int capacity;//表格的容量---桶的个数
    int size;//有效元素的个数
    double loadFact=0.75;

    public HashBucket(int initCap){
        capacity =initCap;
        if(initCap< 10){
            initCap=10;
        }
        arr=new Node[capacity];
        size=0;
    }
    public int put(int key,int value){
        resize();
        //1.通过哈希函数，计算出所在的桶号
        int buckNo=hashFunc(key);
        //2.在buckNo桶中检测key是否存在
        //检测方式：遍历链表
        Node cur=arr[buckNo] ;
        while(null !=cur){
            if(cur.key==key){
                int oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }
            cur=cur.next;
        }
        //3.key 不存在，将key-value插入到哈希桶中
        cur=new Node(key,value);
        cur.next=arr[buckNo];
        arr[buckNo]=cur;
        size++;
        return value;
    }

    private void resize(){
        //装载因子超过0.75时进行扩容-----按照2倍
        if(size*10/capacity>loadFact*10){
            int newCap=capacity*2;
            Node[] newArr=new Node[capacity*2];
            //将arr中的节点搬移到newArr中；
            for (int i=0;i<capacity;i++){
                Node cur= arr[i];
                while (null!=cur){
                    arr[i]=cur.next;
                    //将节点插入到newArr中
                    //1.计算cur在newArr中的桶号；
                    //int buckNo=hashFunc(cur.key);//不行，用的旧容量的大小
                    int buckNo=cur.key % newCap;
                    //2.将cur插入到newArr
                    cur.next=newArr[buckNo];
                    newArr[buckNo]=cur;
                    //取arr中i号桶的下一个节点；
                    cur=arr[i];
                }
            }
            arr=newArr;
            capacity=newCap;
        }
    }

    public boolean remove(int key){
        //1.通过哈希函数计算key的桶号
        int buckNo=hashFunc(key);
        //2.在buckNo桶中找key所对应的节点
        // 找到后将节点删除
        Node cur=arr[buckNo];
        Node prev=null;
        while(null!=cur){
            if(cur.key==key){
                //找到与key所对应的节点，将该节点删除
                //
                if(prev==null){
                    //删除的节点刚好是第一个绩点
                    arr[buckNo]=cur.next;

                }else {
                    //删除其他节点
                    prev.next=cur.next;
                }

                --size;
                return true;
            }else {
                prev=cur;
                cur=cur.next;
            }
        }
        return false;
    }


    private int hashFunc(int key){
        return key % capacity;
    }

    //O(1)
    public boolean containsKey(int key){
        //1.计算key所在的桶号
        int buckNo =hashFunc(key);
        //2.在buckNo
        Node cur=arr[buckNo];
        while (null!=cur){
            if(cur.key==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //O(N)
    public boolean containsValue(int value){
        //注意：哈希桶是根据key来计算哈希地址的
        //因此：找value，不能计算出value在哪个桶中
        // 在value时，必须要遍历所有的桶
        for(int buckNo=0;buckNo <capacity;buckNo++){
            Node cur=arr[buckNo];
            while (null!=cur){
                if(cur.value==value){
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }
    public int size(){
        return  size;
    }

    public static void main(String[] args) {
        HashBucket ht=new HashBucket(5);
        ht.put(1,1);
        ht.put(11,1);
        ht.put(2,1);
        ht.put(22,22);
        ht.put(6,1);
        ht.put(5,5);
        ht.put(51,51);
        ht.put(8,8);
        System.out.println(ht.size);
        System.out.println(ht.containsKey(5));
        System.out.println(ht.containsValue(15));
        //ht.remove(5);
        ht.put(13,51);
        System.out.println(ht.containsKey(5));
        System.out.println(ht.capacity);


    }
}
