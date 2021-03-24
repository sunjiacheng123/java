
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        long date1=System.currentTimeMillis();
        long start=1615862497000l;
        long end=1615873297000l;
        long s1=1615959000000l;
        long e1=1616043600000l;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2021-03-15 14:50:00";
        long date = ft.parse(time).getTime();
        System.out.println(ft.format(new Date(start)));
        System.out.println(ft.format(new Date(end)));
        System.out.println(ft.format(new Date(s1)));
        System.out.println(ft.format(new Date(e1)));

        System.out.println(date);

        System.out.println(new Date());
    }
}
