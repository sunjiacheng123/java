import com.google.common.primitives.Ints;

public class SimpleTest {
    public static void main(String[] args) {
        System.out.println(Ints.compare(10, 3));//1
        System.out.println(Ints.compare(2,2));//0
        System.out.println(Ints.compare(2,3));//-1
    }
}
