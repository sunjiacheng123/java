import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        System.out.println(StringUtils.equals("a", "a"));
        List<String > list = Lists.newArrayList("1" ,"2");
        System.out.println(StringUtils.join(list, ","));

        // List<String> -> FileUtils.readLines()
        // FileUtils.writeLines();

        // IOUtils.write(Gson -> String -> getBytes[], ((HttpServletResponse)response).getOutputStream());


        // RandomUtils.nextInt()
        UUID.randomUUID().toString();  // -
        String id = RandomStringUtils.randomAlphanumeric(32);



        for(int i=0; i<10; i++) {
            System.out.println(i);
        }
    }
}
