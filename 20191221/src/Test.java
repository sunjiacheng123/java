/*
数据结构：
1.线性结构（顺序结构，链式结构）
2.树形结构：例如二叉树，一对多
3.图形结构：多对多

Object类是所有类的基类
基类的引用可以指向所有子类
如果是继承方式实现
子类 和 基类  is--a


 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Collection <String> c=new ArrayList<>();
        c.add("sad");
        Integer i5 = Integer.valueOf(100);
        List<Integer> L1 = new ArrayList<>();  // 一维的动态数组
        List<Integer> L2 = new ArrayList<>();
        List<Integer> L3 = new ArrayList<>();

        List<List<Integer>> L = new ArrayList<>();
        L.add(L1);
        L.add(L2);
        L.add(L3);
    }

}
