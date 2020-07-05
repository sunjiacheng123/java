/*
排序：
内部排序：
插入排序：时间复杂度：O（N^2）
          空间复杂度：O（1）
          空间复杂度：一个算法在运行期间需要空间和问题规模N的数学表达式--->概念
                      一个算法在运行期间是否借助辅助：如果借助的辅助空间是常数--->O(1)
                                                      如果借助的辅助空间是变量--->new T（N）--->O（N）
          最优情况：O(N)-->用户提前有序
          最差场景：O(N)-->逆序
插入排序应用场景：
    比较费时间的操作：要搬移元素，如果搬移元素个数比较少，就比较适合插入排序
    序列接近有序或者数据个数比较少
 */

/*
实际情况：元素比较凌乱，个数比较多
要求：采用插入排序的思想对上述场景进行排序
将序列变成：接近有序，数据变少：分组
最容易想到的方式：平均分组，每组应用插入排序

希尔分组：按照一定间隔分组
看一个排序算法是否稳定：
    该排序算法在进行的过程中是否将夸元素进行交换或者夸元素进行插入---->是：则不稳定
 */

/*
选择排序：
时间复杂度：O(N^2)
空间复杂度：O(1)
稳定性：不稳定

 */

import java.util.Arrays;

public class Test {
    public static void insertSort(int[] array){
        for (int i=1;i<array.length;++i){
            //1.找待插入元素在前面已排好序部分的位置
            int key=array[i];
            int end=i-1;
            //带插入元素为最小元素的情况   8.3
            while(end>=0 && key<array[end]){
                array[end+1]=array[end];
                end--;
            }
            //2.插入元素
            array[end+1]=key;
        }
    }
    //希尔排序  O(N^1.25)··O(1.6N^1.25)
    public static void shellSort(int[] array){
        //int gap=3;
        int gap=array.length;
        while (gap>0){
            gap=gap/3+1;//gap每次除2，每次取素数
            for (int i=gap;i<array.length;++i){
                //1.找待插入元素在前面已排好序部分的位置
                int key=array[i];
                int end=i-gap;
                //带插入元素为最小元素的情况
                while(end>=0 && key<array[end]){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                //2.插入元素
                array[end+gap]=key;
            }
            gap--;
        }
    }

    //选择排序
    public static void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            //具体选择的方式:找到最大元素的位置
            int max=0;
            for(int j=1;j<=array.length-1-i;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            if(array.length-1-i != max){
                swap(array,max,array.length-1-i);
            }
        }
    }
    //[]
    //[)
    public static void selectSortOp(int[] array){
        int begin =0,end=array.length-1;
        while(begin<end){
            int max=begin;
            int min=begin;
            int index=begin+1;
            while (index<=end){
                if (array[index] > array[max]) {
                    max=index;
                }
                if(array[index]<array[min]){
                    min=index;
                }
                ++index;
            }
            //将最大元素放在区间最后位置
            if (max != end) {
                swap(array,max,end);
            }
            //如果最小元素刚好在区间最后一个位置，不行更新min
            if (min == end){
                min = max;
            }
            if (min != begin) {
                swap(array,min,begin);
            }
            begin++;
            end--;
        }
    }


    public static void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }

    public static void main(String[] args) {
        int[] array={3,8,2,6,5,7,1,4,0,9};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        selectSortOp(array);
        //heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
