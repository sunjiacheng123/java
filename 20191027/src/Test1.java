/*
顺序表的测试类
 */

import java.util.Arrays;

public class Test1 {
    public static void main2(String[] args) {
        List list=new List();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);
        list.display();
        list.remove(2);
        list.display();
        //int[] arr={1,2,3,4};
        //System.out.println(Arrays.binarySearch(arr,3));
    }


}
