import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;

import java.util.ArrayList;
import java.util.List;

public class ImmutableStudy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        //ImmutableList.copyOf
        ImmutableList<String> imlist = ImmutableList.copyOf(list);
        System.out.println("imlist：" + imlist);

        //ImmutableList.of
        ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
        System.out.println("imOflist：" + imOflist);

        ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "c", "b", "a", "d", "b");//建立排序不重复set
        System.out.println("imSortList：" + imSortList);

        //set直接转list
        ImmutableList<String> i1 = ImmutableList.copyOf(imSortList);
        System.out.println("imlist：" + imlist);

        //list直接转SortedSet
        ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imSortList);
        System.out.println("imSortSet：" + imSortSet);

        List<String> l = new ArrayList<String>();
        for (int i = 0; i <= 10; i++) {
            l.add(i + "x");
        }
        System.out.println("l：" + l);

        //截取集合部分元素
        ImmutableList<String> imInfolist = ImmutableList.copyOf(list.subList(1, 2));//截取下表区间的数据，【a，b）
        System.out.println("imInfolist：" + imInfolist);

    }
}
