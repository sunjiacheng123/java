import java.util.*;

/*

 */
public class Test {
    public static void main1(String[] args) {
        Map<String,String> m1=new TreeMap<>();
        m1.put("peach","桃");
        m1.put("orange","橘子");
        m1.put("apple","苹果");
        System.out.println(m1.size());
        System.out.println(m1);
        //验证key是否可以重复---如果key不存在，将该key-value组成的键值对直接插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，map会保证key是一个有序的序列----
        // 延伸：插入期间肯定要对key进行比较--->
        //延伸：如果key是自定义类型的元素，该类的对象必须能够比较大小--->
        //延伸：实现comparable接口comparato
        m1.put("orange","橙子");
        System.out.println(m1.size());
        System.out.println(m1);
        //key是一定不能为空的，如果为空会派出空指针异常
        //原因：如果key为空就无法进行比较
        //m1.put(null,"无名");
        //value可以为null
        m1.put("无名",null);
        //返回值：如果key不存在，将该键值对插入，然后返回null
        //        如果key存在，使用value替换原key所对应的value，返回value
        System.out.println(m1.put("orange","橘子"));

        //get(key)
        //如果key存在，返回key所对应的value
        //如果key不存在，返回null
        //如果key存在，返回空指针异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("water"));
        //System.out.println(m1.get(null));
        //如果key存在，不会将value替换
        System.out.println(m1.getOrDefault("apple","苹果手机"));
        System.out.println(m1.getOrDefault("water","西瓜"));
        System.out.println(m1.size());
        //时间复杂度：O(logN)---找key是根据map底层结构的特性进行比较
        if(m1.containsKey("apple")){
            System.out.println("在");
        }else{
            System.out.println("不在");
        }
        //时间复杂度--O(N)----找value实际进行的是整体的遍历
        if(m1.containsValue("苹果")){
            System.out.println("有");
        }
        //remove(key)
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null
        System.out.println(m1.remove("apple"));
        System.out.println(m1.remove("aaaa"));

        //打印所有的key
        //keyset（）将map中的所有key放在set中返回了
        for(String s : m1.keySet()){
            System.out.println(s+" ");
        }
        //打印所有的kvalue
        for(String s : m1.values()){
            System.out.println(s+" ");
        }
        //打印所有的键值对
        for(Map.Entry<String,String> e : m1.entrySet()){
            System.out.println(e.getKey()+"---"+e.getValue());
        }
    }

    public static void main2(String[] args) {
        Map<String,String> m1=new HashMap<>();
        m1.put("peach","桃");
        m1.put("orange","橘子");
        m1.put("apple","苹果");
        System.out.println(m1.size());
        System.out.println(m1);
    }

    public static void main3(String[] args) {
        Set<String> s=new TreeSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);
        //有序
        System.out.println(s.add("apple"));
        System.out.println(s);

        if(s.contains("sss")){
            System.out.println("zai");
        }else {
            System.out.println("buzai");
        }

        //遍历---迭代器：设计模式--->以此寻访容器中的元素，而又无需了解其底层数据结构或者无需底层接口实现
        Iterator<String> it=s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void main4(String[] args) {
        Set<String> s=new HashSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);
        //无序
        System.out.println(s.add("apple"));
        System.out.println(s);

        if(s.contains("sss")){
            System.out.println("zai");
        }else {
            System.out.println("buzai");
        }

        //遍历---迭代器：设计模式--->以此寻访容器中的元素，而又无需了解其底层数据结构或者无需底层接口实现
        Iterator<String> it=s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
