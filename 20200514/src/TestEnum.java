import java.lang.reflect.Constructor;

enum Enum{
    RED("红色",1),BLACK("黑色",2),GREEN("绿色",3);
    //枚举的构造方法是私有的，不能用public和protected修饰
    Enum (String color,int key){
        this.color=color;
        this.key=key;
    }

    private String color;
    int key;
}



public class TestEnum {
    public static void test(Enum color){
        switch (color){
            case RED:
                System.out.println("红色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("无效枚举类型");
                break;
        }
    }

    public static void test3(){
        try {
            Class<?> enumclass=Class.forName("Enum");
            //注意：自己实现的枚举构造方法有两个参数，但是编译器会给用户实现的枚举多增加两个参数：string，int
            Constructor<?> enumconstruct=enumclass.getDeclaredConstructor(String.class,int.class,String.class,int.class);
            enumconstruct.setAccessible(true);
            Enum red=(Enum)enumconstruct.newInstance("红色",1,"基类参数",2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test1(){
        Enum[] coloes=Enum.values();
        for(int i=0;i<coloes.length;i++){
            System.out.println(coloes[i]+":"+coloes[i].ordinal());
        }

        Enum red=Enum.valueOf("RED");
        System.out.println(red);

//        注意：字符串参数如果在枚举类中有对应的成员才可以转化成功
//        Enum yellow=Enum.valueOf("YELLOW");
//        System.out.println(yellow);

        System.out.println(red.compareTo(Enum.RED));
        System.out.println(red.compareTo(Enum.GREEN));

    }

    public static void main(String[] args) {
        int num=1;
        //System.out.println(num==Enum.RED);
        test1();
    }
}
