import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.Test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class BeanutilesTest {
    @Data
    public  static class Address {
        private String email;

        public Address(String email) {
            this.email = email;
        }
    }
    @Data
    public static class UserInfo {
        private String userName;
        private int age;
        private Address address;
        private List<String> friendsNames;
        private Map<String, String> tag;

        public UserInfo() {
        }

        UserInfo(String userName, int age, Address address, List<String> friendsNames, Map<String, String> tag) {
            this.userName = userName;
            this.age = age;
            this.address = address;
            this.friendsNames = friendsNames;
            this.tag = tag;
        }
    }
    @Test
    public void test() {
        List<String> friendList = Lists.newArrayList("张三", "李四");
        Map<String, String> tag = Maps.newHashMap();
        tag.put("key1", "value1");
        tag.put("key2", "value2");
        UserInfo userInfo = new UserInfo("tuacy", 18, new Address("1@qq.com"), friendList, tag);
        try {
            Map<String, Object> propertyMap = PropertyUtils.describe(userInfo);
            Object friend0 = PropertyUtils.getIndexedProperty(userInfo, "friendsNames[0]"); // 张三
            Object friend0Temp = PropertyUtils.getIndexedProperty(userInfo, "friendsNames", 0); // 张三
            Object mapperProperty = PropertyUtils.getMappedProperty(userInfo, "tag(key1)"); // value1
            Object mapperPropertyTemp = PropertyUtils.getMappedProperty(userInfo, "tag", "key1"); // value1
            Object nestedProperty = PropertyUtils.getNestedProperty(userInfo, "address.email"); // 1@qq.com
            Object name = PropertyUtils.getProperty(userInfo, "userName"); // tuacy
            PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(userInfo, "userName"); // PropertyDescriptor是对属性的一个封装
            PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(userInfo); // 获取所有的属性
            Class<?> classType = PropertyUtils.getPropertyType(userInfo, "address"); // 获取属性的类型Address
            Method getMethod = PropertyUtils.getReadMethod(PropertyUtils.getPropertyDescriptor(userInfo, "userName")); // getUserName()方法
            Object simpleProperty = PropertyUtils.getSimpleProperty(userInfo, "userName");
            Method setMethod = PropertyUtils.getWriteMethod(PropertyUtils.getPropertyDescriptor(userInfo, "userName")); // setUserName()方法
            boolean isReadable = PropertyUtils.isReadable(userInfo, "userName"); // true
            boolean isWriteable = PropertyUtils.isWriteable(userInfo, "userName"); // true
            PropertyUtils.setIndexedProperty(userInfo, "friendsNames[0]", "张三第一次修改"); // 修改friendsNames第一个元素
            PropertyUtils.setIndexedProperty(userInfo, "friendsNames", 0, "张三第二次修改"); // 修改friendsNames第一个元素
            PropertyUtils.setMappedProperty(userInfo, "tag(key1)", "value1第一次修改"); // 修改tag key为key1的值
            PropertyUtils.setMappedProperty(userInfo, "tag", "key1", "value1第二次修改"); // 修改tag key为key1的值
            PropertyUtils.setNestedProperty(userInfo, "address.email", "1007@qq.com"); // 修改address属性对象对应的email属性
            PropertyUtils.setProperty(userInfo, "userName", "tuacy0"); // 修改userName对应的属性值
            PropertyUtils.setSimpleProperty(userInfo, "age", 19); // 修改age对应的属性值
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        List<String> friendList = Lists.newArrayList("张三", "李四");
        Map<String, String> tag = Maps.newHashMap();
        tag.put("key1", "value1");
        tag.put("key2", "value2");
        UserInfo userInfo = new UserInfo("tuacy", 18, new Address("1@qq.com"), friendList, tag);
        try {
            Object voClone = BeanUtils.cloneBean(userInfo);//克隆对象
            System.out.println(voClone);
            UserInfo userInfo1 = new UserInfo();
            BeanUtils.copyProperties(userInfo1, userInfo);//复制属性
            BeanUtils.copyProperty(userInfo1, "userName", "user1"); //复制属性，相当于设置属性
            Map<String, String> map = BeanUtils.describe(userInfo); // 获取所有的属性名字和属性对应的值，注意这里值都会转换成String
            String[] arrays =  BeanUtils.getArrayProperty(userInfo, "friendsNames"); // friendsNames数组转换成数组
            Object item = BeanUtils.getIndexedProperty(userInfo, "friendsNames[1]"); // 张三
            Object itemItem = BeanUtils.getIndexedProperty(userInfo, "friendsNames", 0); // 张三
            Object value = BeanUtils.getMappedProperty(userInfo, "tag(key1)"); // value1
            Object valueValue = BeanUtils.getMappedProperty(userInfo, "tag", "key1"); // value1
            Object email = BeanUtils.getNestedProperty(userInfo, "address.email"); // 1@qq.com  获得嵌套属性作为字符串返回
            String userName = BeanUtils.getProperty(userInfo, "userName"); // tuacy
            String userName0 = BeanUtils.getSimpleProperty(userInfo, "userName"); // tuacy  获得属性值作为字符串返回
            UserInfo userInfo2 = new UserInfo();
            BeanUtils.populate(userInfo2, PropertyUtils.describe(userInfo)); // map转换成对象
            BeanUtils.setProperty(userInfo2, "userName", "tuacy0"); // map转换成对象
            NullPointerException nullPointerException = new NullPointerException("情况一");
            NullPointerException nullPointerException1 = new NullPointerException("情况二");
            BeanUtils.initCause(nullPointerException, nullPointerException1); // map转换成对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
