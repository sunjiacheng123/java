import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Tes {
    //1.获取student字节码文件对象
    public static void test1() throws ClassNotFoundException {
        //1.每个类里面实际都包含一个class的静态属性
        Class<?> stuClass=Student.class;
        System.out.println(stuClass);

        //2.通过对象调用getclass（）
        Student s=new Student("peter","nan");
        Class<?> stuClass1=s.getClass();

        //3.通过class静态方法forname
        Class<?> stuClass2=Class.forName("Student");

        //三个stuClass相同，一个类最多只会被加载一次，
        System.out.println(stuClass.equals(stuClass1));
        System.out.println(stuClass1.equals(stuClass2));
        System.out.println(stuClass2.equals(stuClass));

    }

    //2.获取类的构造器对象---前提是：必须先要拿到字节码对象
    public static void test2(){
        try {
            //获取字节码文件对象
            Class<?> stuClass = Class.forName("Student");
            //获取构造器对象
            //getConstructors()：获取所有公有的构造器---> Constructor[]
            Constructor<?>[] stuConstruct1=stuClass.getConstructors();
            System.out.println(stuConstruct1.length);

            //注意：getConstructor获取具体某个公有的构造器--想要获取哪个狗在其，该方法的参数与对应的构造器的参数匹配
            Constructor<?> stuConstruct2=stuClass.getConstructor(String.class,int.class);
            System.out.println(stuConstruct2);
            //getDeclaredConstructors：获取所有的前构造器对象----与访问权限无关
            Constructor<?>[] stuConstruct4=stuClass.getDeclaredConstructors();
            System.out.println(stuConstruct4.length);
            //如果没有找到对应的构造器，该方法会抛出异常
            Constructor<?> stuConstruct5=stuClass.getDeclaredConstructor(String.class);
            System.out.println(stuConstruct5);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //3.通过构造器来实例化对象
    public static void test3(){
        try {
            Class<?> stuClass=Class.forName("Student");

            //获取构造器；
            Constructor<?> stuConstruct=stuClass.getDeclaredConstructor(String.class);
            //实例化对象
            //如果构造器是private的，则不能直接用来实例化对象
            stuConstruct.setAccessible(true);//将该构造器的访问权限设置文public
            Student s=(Student) stuConstruct.newInstance("peter");
            System.out.println(s);

            //反射属性
            //getFields:获取所有的公有的属性
            Field[] fields=stuClass.getFields();
            System.out.println(fields.length);
            //抛异常：因为student中那么是私有的，而getField方法是只获取公有的
            //Field name=stuClass.getField("name");
            //System.out.println(name);

            Field[] fields1=stuClass.getDeclaredFields();
            System.out.println(fields1.length);

            Field name=stuClass.getDeclaredField("name");
            System.out.println(name);
            name.setAccessible(true);
            name.set(s,"asd");
            System.out.println(s);

            //反射方法
            Method setid=stuClass.getDeclaredMethod("setId", int.class);
            setid.invoke(s,200);

            Method getid=stuClass.getDeclaredMethod("getId");
            getid.setAccessible(true);
            System.out.println(getid.invoke(s));

            }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void test5(){

    }

    public static void main(String[] args) throws ClassNotFoundException {
        //test1();
        //test2();
        test3();
    }
}
