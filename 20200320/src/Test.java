/*
创建优先级队列
 */
//为了实现简单，假设优先级队列中放置int
//假设：实现一个小堆


import java.util.Arrays;
interface Comp{
    public  int compare(int l,int r);
}

class Less implements Comp{
    //0: l==r
    //>0: l>r
    //<0: l<r
    public int compare (int l,int r){
        return l-r;
    }
}

    class Greater implements Comp{
        public int compare(int l,int r){
            return r-l;
        }
    }

public class Test {
    private  int[] array;
    private  int size;
    Comp compare=null;
    public Test(){
        //默认的构造--将其底层容量设置为11
        array=new int[11];

    }
    public Test(int initCapacity,Comp comp){
        if(initCapacity < 1){
            //标准库：抛出一个非法参数异常
            initCapacity=11;
        }
        array=new int[initCapacity];
        size=0;
    }
    public Test(int[] arr,Comp comp){
        //注意标准库中没有该接口---标准库中可以采用集合来构造优先级队列
        array=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            array[i]=arr[i];
            size++;
        }
        //将array中的元素调整，让其满足小堆的性质
        int lastLeaf=(array.length-2)>>1;
        for(int root =lastLeaf;root>=0;root--){
            shiftDown(root);
        }
    }
    int peek(){
        return array[0];
    }
    boolean offer(int x){

        grow();

        array[size++]=x;
        shiftUp(size-1);

        return true;
    }
    //删除堆顶的元素
    int poll(){
        int ret=array[0];
        swap(0,size-1);
        size--;
        shiftDown(0);
        return ret;
    }

    boolean isEmpty(){

        return 0==size;
    }
    int size(){
        return size;
    }
    //扩容
    private void grow(){
        int oldC=array.length;
        int newC=oldC+((oldC<64)?(oldC+2):(oldC>>1));
        array=Arrays.copyOf(array,newC);
    }

    private  void shiftUp(int child){
        int parent=(child-1)>>1;
        while (parent>=0){
            if(array[child]<array[parent]){
                swap(child,parent);
                child=parent;
                parent=(child-1)>>1;
            }else{
                return;
            }
        }
    }

    //parent表示本次需要调整的节点的下标
    //调整一parent为根的二叉树
    //注意：调整之前，一定要保证parent的左右子树一定满足小堆的性质
    //如果要检测parent是否满足小堆的性质，只需要使用parent与其孩子进行比较
    //满足小堆性质-->说明以parent为根的二叉树已经是小堆
    //不满足小堆性质-->说明parent比其孩子大，此时需要将parent与其较小的孩子进行交换
    //                交换完以后，parent较大的元素向下移动，可能导致其子树不满足小堆性质
    //                 需要继续调整其子树
    private void shiftDown(int parent){
        //使用child标记parent的较小的孩子
        //默认情况下先让其标记做孩子，因为parent可能只有做孩子
        int child =parent*2+1;
        int size=array.length;
        while (child<size){
            //找较小的孩子
            //在通过左右孩子比较前，必须要保证有孩子存在--while循环条件已经保证做孩子存在
            if(child+1<size && array[child+1]<array[child]){
            //if(child+1 <size && compare.compare(array[]))
                child += 1;
            }
            //检查双亲是否比较小的孩子大
            if(array[parent]>array[child]){
                //说明parent不满足小堆的性质--交换
                swap(parent,child);
                //parent较大的元素向下移动可能会导致子树不满足堆的性质
                parent=child;
                child=parent*2+1;
            }else{
                //以parent为根二叉树已经瞒住堆的性质
                return;
            }
        }
    }

    private void swap(int parent,int child){
        int tmp=array[parent];
        array[parent]=array[child];
        array[child]=tmp;
    }

    public static void main(String[] args) {
        int arrar[]={5,3,7,1,4,6,8,0,2};

        Test t=new Test(arrar,new Greater());
        t.offer(9);
        System.out.println(t.peek());
        System.out.println(t.size);
        t.offer(-1);
        System.out.println(t.peek());
        System.out.println(t.size());
    }
}
