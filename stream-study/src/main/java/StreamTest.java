import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void filterTest(){
        //返回结果生成新的流中只包含满足筛选条件的数据
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result=nums.stream().filter(n -> n>2).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void mapTest(){
        //将流中的元素进行再次加工形成一个新流，流中的每一个元素映射为另外的元素
        List<Person> list = new ArrayList<>();
        list.add(new Person("sada",12,45));
        list.add(new Person("asd",177,69));
        list.add(new Person("dds",8,484));
        List<String> result=list.stream().map(n -> n.getName()).collect(Collectors.toList());//得到名字的集合
        System.out.println(result);
    }

    @Test
    public void flatMapTest(){
        //flatMap()：扁平化映射，它具体的操作是将多个stream连接成一个stream，这个操作是针对类似多维数组的，比如集合里面包含集合，相当于降维作用。
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(4, 5, 6);
        List<Integer> num3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> lists = Arrays.asList(num1, num2, num3);
        Stream<Integer> outputStream = lists.stream().flatMap(l -> l.stream());
        List<Integer> flatMapResult = outputStream.sorted().collect(Collectors.toList());
        System.out.println(flatMapResult);
        //示例场景：取出所有部门人员的姓名，就可以这样写（伪代码）：
        // 1、取出所有部门
        //List<Department> departments = ...;
        // 2、这个时候可以利用flatMap先将所有部门的所有人员汇聚起来
        //List<Person> persons = departments.stream.flatMap(d->d.getPersonList()).collect(Collectors.toList())；
        // 3、再利用map()方法取出
    }

    @Test
    public void skipMapTest() {
        List<String> words = Arrays.asList("ma", "zhi", "chu", "wait", "you", "follow");
        List<String> skipWord = words.stream().skip(4).collect(Collectors.toList());
        System.out.println(skipWord);
        Stream<String> stream3 = Stream.generate(() -> "love").limit(10);
        String[] strArr3 = stream3.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr3));
    }
}
