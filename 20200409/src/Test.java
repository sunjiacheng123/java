import java.awt.event.FocusEvent;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class Test {
    /*
    冒泡排序
     */
    public static void BobbleSort(int[] arr){
        //用来优化冒泡---冒泡一定趟数后就已经有序了，后序的冒泡就不需要冒了
        //如果已经有序，在冒泡是肯定不需要元素的交换了
        boolean isChange=false;

        //外层循环控制冒泡的趟数
        for (int i=0;i<arr.length-1;i++){
            //具体冒泡的方式
            //一趟冒泡 的方式，让相邻的两个元素进行比较
            //让大的元素往后移动
            isChange=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                    isChange=true;
                }
            }

            if(isChange=false){
                return;
            }
        }
    }

    public static void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }

    //场景：数据局密集，几种在某个范围中
    //时间复杂度：O(N)  N：表示区间中元素的个数
    //空间复杂度：O(M)  M:表示区间中元素种类的个数
    //稳定性：稳定
    public static void countSort(int[] array){
        //1.统计元素的范围
        int min=array[0];
        int max=array[0];
        for (int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        //2.开辟计数的空间
        //该范围中最多包含不同元素的个数
        int range=max-min+1;
        int[] arrayCount=new int[range];
        //3.统计每个元素出现的个数
        for (int i=0;i<array.length;i++){
            arrayCount[array[i]-min]++;
        }
        //4.对元素进行回收--排序
        int index=0;
        for(int i=0;i<range;i++){
            while (arrayCount[i]--!=0){
                array[index++]=i+min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,5,6,3,2,4,5,6,8,3,9,2,9};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
