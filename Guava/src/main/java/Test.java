import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Test {
    public static void main(String[] args) {


        Long l=161457932400l;
        String str = "2013-01-21 15:15:23";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s=sdf.format(Long.valueOf(1614650550000l));
        System.out.println(s);
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<String ,String> map=new HashMap<>();
        String string=map.get("123");
        System.out.println(date);
        System.out.println(date.getTime());
//        Map<String,Map<String,String>> big=new HashMap<>();
//        Map<String,String> map=new HashMap<>();
//        map.put("12","213");
//        big.put("1",map);
//        if(big.containsKey("1")){
//            Map<String,String> map1=big.get("1");
//            map1.put("45","445");
//        }
//        System.out.println(big);
//
//        long l=System.currentTimeMillis();
//        long l1= LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault()).plusMinutes(10).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        ZonedDateTime l2= LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault()).plusMinutes(10).atZone(ZoneId.systemDefault());
//        System.out.println(l);
//        System.out.println(Instant.ofEpochMilli(l));
//        System.out.println(l2);
//        System.out.println(l1);
//        System.out.println("******************");
//
//        StringBuffer sb=new StringBuffer("");
//        long time=System.currentTimeMillis();
//        sb.append(" and 'start' <=").append(time);
//        System.out.println(sb);
//        String id="host_id";
//        String s=" if(indexOf(tags.tagk, ''{0}'')>0,tags.tagv[indexOf(tags.tagk, ''{0}'')], '''') as {0}";
//        System.out.println(MessageFormat.format(s,id));
//        System.out.println(Objects.equal(null,"a"));
//        List<String> lists = Lists.newArrayList("1", "2", "3");
//        Map<String, String> maps = Maps.newHashMap();
//        // apache-common-lang
//        Person p = new Person();
//        do1(p);
        // p.age()
        // encode, decode
        // String base64Str = DigsestUtils.base64();
    }

    public static void do1(Person p) {
        // BeanUtils.copyproperties(src, dest);
        Person pp = new Person();

        // BeanUtils.copyproperties(p, pp);
        pp.setName(p.getName());
        pp.setAge(p.getAge());


        pp.setAge(1);
    }
}
