import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;


public class MultimapStudy {
    public static void main(String[] args) {
        Multimap<String, Person> map = ArrayListMultimap.create();
        for (int i = 0; i < 10; i++) {
            Person p = new Person("wang", 12);
            map.put("person", p);
        }
        System.out.println(map.size());//返回所有”键-单个值映射”的个数
        System.out.println(map.keys());
        System.out.println(map.keySet().size());//得到不重复键的数目

        System.out.println("--------------------------");
        Collection<Person> list = map.get("person");
        //list.clear();
        list.add(new Person("sd", 55));
        System.out.println(list.size());
        //list清空后。再加入一个对象后，map中的也变了
        System.out.println(map.size());
        System.out.println(map.keys());

        System.out.println("--------------------");
        Person p = new Person("san", 22);
        map.put("456", p);
        map.put("456", new Person("san", 22));
        System.out.println(map.size());
        System.out.println(map.keys());

        System.out.println(map.values().size());//values()视图能把Multimap里的所有值“平展”成一个Collection<V>

        System.out.println("---------------");
        Person person = new Person("wang", 12);
//        map.put("person",person);
//        System.out.println(map.keys());
        System.out.println(map.remove("person", person));//false,只能remove以前存入的对象
        System.out.println(map.keys());
        System.out.println(map.remove("456", p));//ture
        System.out.println(map.removeAll("person"));//删除所有person
        System.out.println(map.size());
        System.out.println(map.keys());
    }
}
