import org.omg.CORBA.PUBLIC_MEMBER;
import java.lang.reflect.Array;
import java.util.Arrays;
/*

 */
public class Test {
    //合并两个有序数组
    //[left,mid) [mid,right)
    public static void mergeDate(int[] arrar,int left,int mid,int right ,int[] tmp){
        int index=left;
        int begin1=left,end1=mid,begin2=mid,end2=right;
        while(begin1<end1 && begin2<end2){
            if (arrar[begin1] <= arrar[begin2]) {
                tmp[index++]=arrar[begin1++];
            }else{
                tmp[index++]=arrar[begin2++];
            }
        }
        //如果第一个区间中还有数据
        while (begin1<end1){
            tmp[index++]=arrar[begin1++];
        }
        //如果第二个区间有数据
        while (begin2<end2){
            tmp[index++]=arrar[begin2++];
        }
    }

    /*
     归并排序原理：
     稳定的排序算法
     时间复杂度：O(NlogN)
     空间复杂度：O(N)
     */
    public static void mergeSort(int[] array,int left,int right,int[] tmp){
        //优化，在right-left<16时，可以使用插入排序
        if(right-left>1){
            int mid=left+((right-left)>>1);
            //左半部分
            mergeSort(array,left,mid,tmp);
            //右半部分
            mergeSort(array,mid,right,tmp);
            //归并
            mergeDate(array,left,mid,right,tmp);
            //System.out.println(Arrays.toString(tmp));
            //归并结束后，有序序列存储在array中去
            //将tmp中的数据拷贝到array中去
            System.arraycopy(tmp,left,array,left,right-left);
        }
    }

    public static void mergeSortNor(int[] array){
        int[] tmp=new int[array.length];
        int gap=1;
        while(gap<array.length){

            for(int i=0;i<array.length;i+=gap*2){
                int left=i;
                int mid=left+gap;
                int right=mid+gap;
                if(mid>array.length){
                    mid=array.length;
                }
                if(right>array.length){
                    right=array.length;
                }
                mergeDate(array,left,mid,right,tmp);
            }
            System.arraycopy(tmp,0,array,0,array.length);
            gap=gap<<1;
        }
    }

    public static void main(String[] args) {
        int[] array={3,8,2,6,9,7,1,4,0,5};
        int[] tmp=new int[array.length];
        //mergeSort(array,0,array.length,tmp);
        mergeSortNor(array);
        //System.out.println(Arrays.toString(tmp));
        System.out.println(Arrays.toString(array));
    }

    public static void main1(String[] args) {
        int[] array={3,8,2,6,9,7,1,4,0,5};
        int[] tmp=new int[array.length];
        for(int i=0;i<5;i++){
            tmp[i]=i;
        }
        System.arraycopy(tmp,0,array,0,array.length);
        System.out.println(Arrays.toString(array));
    }
}
