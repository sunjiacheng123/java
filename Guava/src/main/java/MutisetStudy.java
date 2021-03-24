import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;

public class MutisetStudy {
    public static void main(String[] args) {
        String str="sda,sd,sad,as,s,da,sa,sd,sad,sda";
        String[] strings=str.split(",");
        Multiset<String> set= HashMultiset.create();
        for(String s: strings){
            set.add(s);
        }
        //查看每个set中每个元素的个数
        for(String s:set.elementSet()){
            System.out.println(s+" count: "+set.count(s));
        }

        System.out.println("--------------------------");
        //如果set不存在qw，就加入两个wq
        if(!set.contains("qw")){
            set.add("wq",2);
        }
        for(String s:set.elementSet()){
            System.out.println(s+" count: "+set.count(s));
        }

        System.out.println("----------------");
        //设置sa的个数为5个
        set.setCount("sa",5);
        //将原来两个的wq改为三个
        set.setCount("wq",2,23);
        for(String s:set.elementSet()){
            System.out.println(s+" count: "+set.count(s));
        }

        System.out.println("-----------------");
        List<String> list=new ArrayList<>();
        list.add("wq");
        list.add("sa");
        set.removeAll(list);//set删除list中出现的元素
        //set.retainAll(list);//set保留list中出现的元素，其他元素删除
        for(String s:set.elementSet()){
            System.out.println(s+" count: "+set.count(s));
        }
        System.out.println("元素个数总和size:"+set.size());
    }
}
