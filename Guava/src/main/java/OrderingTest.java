import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;


import java.util.*;

public class OrderingTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 9, 7, 2, 65, 85, 2, 3, 1);
        Collections.sort(list, Ordering.natural());//从小到大排序
        System.out.println(list.toString());
        List<Integer> l4 = Ordering.natural().greatestOf(list, 4);//返回最大的K个
        System.out.println(l4.toString());

        System.out.println("--------------");
        List<String> listString = Lists.newArrayList("wang", "test", "asda");
        Collections.sort(listString, Ordering.usingToString());//字符串按字典顺序排序
        System.out.println(listString.toString());

        System.out.println("-----------------");
        List<Integer> l = Arrays.asList(1, 5, 3, 8, 2);
        Collections.sort(l, Ordering.natural().reverse());//倒序排序
        System.out.println(l.toString());
        System.out.println(Ordering.natural().max(l).toString());//获取最大的元素

        System.out.println("---------------");
        List<Integer> l1 = Arrays.asList(1, 5, null, 3, 8, 2);
        Collections.sort(l1, Ordering.natural().nullsFirst());//排序后把null放在最前面
        System.out.println(l1.toString());
        Collections.sort(l1, Ordering.natural().nullsLast());//排序后把null放在最后面
        System.out.println(l1.toString());

        System.out.println("----------------");
        Person p1 = new Person("aiaaming", 12);
        Person p2 = new Person("aiab", 12);
        Person p3 = new Person("wang", 11);
        Person p4 = new Person("bu", 125);
        List<Person> l2 = Lists.newArrayList(p1, p2, p3, p4);
        //年龄相等时，按name排序
        Ordering<Person> ordering = Ordering.from(new AgeComparator()).compound(new nameComparator());
        Collections.sort(l2, ordering);
        l2.forEach(x -> System.out.println(x.toString()));
        //
        List<Integer> l3 = Arrays.asList(1, 5, 3, 8, 2);
        Collections.sort(l3);
        boolean order = Ordering.natural().isOrdered(l3); //是否为按照这样的顺序排好序的！自然的排序
        System.out.println(order);

        System.out.println("------------");
        List<Integer> l5 = Arrays.asList(1, 5, 3, 8, 2);
        List<Integer> duplicateList = Ordering.natural().sortedCopy(l5);// 返回一个副本
        if (!Objects.equals(l5, duplicateList)) {
            duplicateList.add(10);
            System.out.println("副本数组可变");
        }
        List<Integer> duplicateImmutableList = Ordering.natural().immutableSortedCopy(l5); // 返回一个不可变的副本
        if (!Objects.equals(l5, duplicateImmutableList)) {
            try {
                duplicateImmutableList.add(10);
            } catch (Exception e) {
                System.out.println("副本数组不可变");
            }
        }
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person worker1, Person worker2) {
        return Ints.compare(worker1.getAge(), worker2.getAge());
    }
}

class nameComparator implements Comparator<Person> {
    @Override
    public int compare(Person worker1, Person worker2) {
        return worker1.getName().compareTo(worker2.getName());
    }
}