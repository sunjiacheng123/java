import sun.security.x509.EDIPartyName;

import java.util.Arrays;

/*
堆排序：
1.建堆：升序-->大堆  降序-->小堆
 a.找堆的倒数第一个非叶子节点 最后一个叶子：size-1  他的双亲：（（size-1）-1）>>1
 b.从倒数第一个非叶子节点的位置上开始向下调整，一直想前调整到根节点的位置为止
2.利用堆删除的思想来进行排序--->用堆顶元素与堆中最后一个元素进行交换，将堆中元素减少


 */
public class Test {

    //堆排序
/*
时间复杂度
空间复杂度：O(1)
稳定性：不稳定

 */
    public static void shiftDown(int[] array,int parent,int size){
        int child =parent*2+1;
        while(child<size){
            //找左右孩子中较大的孩子
            if(child+1<size && array[child+1]>array[child]){
                child+=1;
            }
            //检测双亲是否比较大的孩子小
            if (array[child]>array[parent]){
                swap(array,child,parent);
                parent=child;
                child=parent*2+1;
            }else {
                break;
            }

        }
    }

    public static void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }

    public static void heapSort(int[] array){
        //1.建堆
        //找倒数第一个非叶子节点
        int lastLeaf=(array.length-1)>>1;
        //从lastLeaf到root的位置不断进行向下调整
        for(int root=lastLeaf;root>=0;root--){
            shiftDown(array,root,array.length);
        }
        //2.利用堆删除的思想进行排序
        int end =array.length-1;
        while (end>=0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }
    /*
    快速排序原理：
    1.从区间中取一个数据做基准值，按照该基准值将区间分割左右两部分
      左部分  基准值  右部分
    2.按照快排的思想排左半部分
    3.按照快排的思想排右半部分
       时间复杂度：O(N)
       最优情况下：O(NlogN)
       场景：每次都均分
       最差情况下：O(N^2)
       场景：数据有序或者接近有序
     4.应用场景：数据量大，比较随机的（数据杂乱）
                 数据量大：将来递归胜读可能比较深-->每次递归都需要在栈中压入一个栈帧
                 栈帧：函数在运行期间要保存的中间结果-->比如：函数中的局部变量、参数、返回值信息
                 栈是有大小的-->可能导致栈溢出

     */
    //方式一：
    //1.让begin从前往后找，找比基准值大的元素，找到之后停止
    //2.让end从后往前找，找比基准值小的元素，找到之后停止
    //3.将begin和end标记的元素进行交换
    //将基准值与begin位置的数据进行交换
    public static int partion(int[] arr,int left,int right){
        int begin=left;
        int end=right-1;
        int key=arr[end];
        while (begin<end){
            //1.begin从前往后找，找比基准值大的元素
            while (begin<end && arr[begin]<=key){
                begin++;
            }
            //2.end从后往前，找比基准值小的元素
            while (begin<end && arr[end]>=key){
                end--;
            }
            if(begin<end){
                swap(arr,begin,end);
            }
        }
        if (begin!=right-1){
            swap(arr,begin,right-1);
        }
        return begin;
    }

    //标准值优化：使用三数取中发堆每次渠道的最值
    //防止出现极端情况，加大出现均分的概率，拿到极值的概率就降低了，
    // 认为：快排看的是平均复杂度O(NlogN)
    public static int getIndex(int[] arr,int left,int right ){
        int mid=left +((right-left)>>1);
        if(arr[left]<arr[right-1]){
            if(arr[mid]<arr[left]){
                return left;
            }else if(arr[mid]>arr[right-1]){
                return right-1;
            }else {
                return mid;
            }
        }
        else{
            if(arr[mid]>arr[left]){
                return left;
            }else if(arr[mid]<arr[right-1]){
                return right-1;
            }else{
                return mid;
            }
        }

    }

    //2.挖坑法
    public static int partion2(int[] arr,int left,int right){
        int begin=left;
        int end =right-1;
        int mid=getIndex(arr,left,right);
        swap(arr,mid,right-1);
        int key=arr[end];
        while (begin<end) {
            //1.begin从前往后找，找比基准值大的元素
            while (begin < end && arr[begin] <= key) {
                begin++;
            }
            //找到了一个比基准值大的元素，用钙元素填end位置的元素
            if(begin<end){
                arr[end--]=arr[begin];
            }
            //2.end从后往前，找比基准值小的元素
            while (begin<end && arr[end]>=key){
                end--;
            }
            //end从后往前找到了一个比基准值小的元素，用该元素填begin 位置的坑
            if(begin<end){
                arr[begin++]=arr[end];
            }
        }
        //用Key填最后一个坑
        arr[begin]=key;
        return begin;
    }
    /*
    前后索引：一前一后
    刚开始时：prev和cur是一前一后的关系
    一段时间后：prev和cur之间有距离
               prev+1，cur之间的元素都比基准值大
    */
    public static int partion3(int[] arr,int left,int right){
        int cur=left;
        int prev=cur-1;
        int mid=getIndex(arr,left,right);
        swap(arr,mid,right-1);
        int key=arr[right-1];
        while(cur<right){
            if(arr[cur]<key && ++prev != cur){
                swap(arr,cur,prev);
            }
            ++cur;
        }
        if(++prev!=right-1){
            swap(arr,prev,right-1);
        }
        return  prev;
    }

    public static void quickSort(int[] arr,int left ,int right){
//        if(right-left<16){
//            //数据量小的时候可以调用别的排序方法,避免栈溢出,
              // 降低栈溢出的概率，但是不能杜绝
//            如果想要绝对的杜绝递归过深导致栈溢出的情况：
//            不要使用递归，用循环
//        }
//        else
        if(right-left > 1){
            //说明区间中至少有两个元素
            //按照基准值对【left，right）
            int dir=partion2(arr,left,right);
            //递归排基准值的左半侧
            quickSort(arr,left,dir);
            //递归排基准值的右半侧
            quickSort(arr,dir+1,right);
        }
    }

    public static void main(String[] args) {
        int[] array={3,8,2,6,9,7,1,4,0,5};
        heapSort(array);
        //quickSort(array,0,array.length);
        System.out.println(Arrays.toString(array));
    }
}
