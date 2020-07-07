import java.util.Stack;

/*
为什么将递归转化为循环需要借助栈的数据结构？
栈的特性：后进先出
递归：后调用的先返回
 */
public class Test {
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
    public static void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }

    void quickSort(int[] arr){
        Stack<Integer> s=new Stack<>();
        s.push(arr.length);
        s.push(0);
        while (!s.empty()){
            int left=s.pop();
            int right=s.pop();
            if(right-left>1){
                int dir=partion(arr,left,right);
                s.push(right);
                s.push(dir+1);
                s.push(dir);
                s.push(left);
            }
        }
    }

}
