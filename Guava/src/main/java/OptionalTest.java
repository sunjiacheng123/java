import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class OptionalTest {
    public static void main(String[] args) {
        Person p=null;
        Optional<Person> optional=Optional.fromNullable(p);
        p=optional.orNull();
        System.out.println(p);

        Preconditions.checkArgument(true);
        String s="54646";
        Preconditions.checkPositionIndex(6,s.length(),s);

    }
}
