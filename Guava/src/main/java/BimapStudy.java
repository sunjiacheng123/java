import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BimapStudy {
    public static void main(String[] args) {
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("sdas", 13);
        biMap.put("sada", 32);
        biMap.put("sad", 89);
        biMap.put("ees", 14);
        biMap.forcePut("sadasd", 14);//将前面value=14的key覆盖
        System.out.println("biMap" + biMap);
        BiMap<Integer, String> map = biMap.inverse();//键值对关系反转
        System.out.println("map" + map);
        //inverse后，biMap和map进行视图关联，修改其中一个，另一个也会做出相同的改变
        map.put(15, "sdadddd");
        System.out.println("biMap" + biMap);
        System.out.println("map" + map);

    }
}
