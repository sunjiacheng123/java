import domain.Person;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.input.XmlStreamReader;
import org.apache.commons.io.output.TeeOutputStream;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IoStudy {
    public static void main(String[] args) {


    }

    @Test
    public void copyFile() {
        File file1 = new File("E:\\1233");
        File file = new File("E:\\1233\\456");
        try {
            FileUtils.copyFile(file1, file);//拷贝文件  不能拷贝目录
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFile() {
        File file1 = new File("E:\\sd");
        FileUtils.deleteQuietly(file1);
    }

    @Test
    public void writeToFile() {
        File file1 = new File("E:\\123.txt");
        try {
            //往文件写入，不覆盖原有数据，设置编码格式
            FileUtils.write(file1, "87", StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void mkdirFile() {
        File file1 = new File("E:\\456\\4\\123.txt");
        File file = new File("E:\\45\\4\\123.txt");
        try {
            //强制创建，如果存在会抛出异常
            //创建父级目录
            FileUtils.forceMkdirParent(file1);
            //创建多级目录，123.txt也被创建成了文件夹
            FileUtils.forceMkdir(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建空文件
        FileUtils.touch(new File("E:\\45\\456.txt"));
    }

    @Test
    public void getInputFile() {
        File file1 = new File("E:\\456\\4\\123.txt");
        File file = new File("E:\\45\\4\\123.txt");
        try {
            //获得文件字节输入流
            InputStream is = FileUtils.openInputStream(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readFile() {
        File file1 = new File("E:\\123.txt");
        try {
            //按行读取文件，保存到list中
            List<String> ls = FileUtils.readLines(file1, StandardCharsets.UTF_8);
            System.out.println(ls.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void IteratorFile() {
        File file1 = new File("E:\\45");
        String[] strings = null;
        //得到文件夹下每个文件
        Iterator<File> ls = FileUtils.iterateFiles(file1, strings, true);
        while (ls.hasNext()) {
            File file = ls.next();
            System.out.println(file);
        }

        //迭代器获得一个文件的每一行
        File file = new File("E:\\45\\4\\123.txt\\123.txt");
        try {
            Iterator<String> it = FileUtils.lineIterator(file);
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sizeFile() {

        File file1 = new File("E:\\45\\4\\123.txt\\123.txt");
        String[] strings = null;
        //如果是文件，直接读取文件大小；如果是目录，级联计算文件下的所有文件大小
        long l = FileUtils.sizeOf(file1);
        System.out.println(l);
    }


    @Test
    public void extensionFile() {

        File file1 = new File("E:\\45\\4\\123.txt\\123.txt");
        System.out.println(file1.getName());
        //获得文件后缀
        System.out.println(FilenameUtils.getExtension(file1.getName()));
        //判断文件后缀是否为指定字符串
        System.out.println(FilenameUtils.isExtension(file1.getName(),"txt"));
        // 盘符
        System.out.println(FilenameUtils.getPrefix("E:\\45\\4\\123.txt\\123.txt"));
        //去除盘符后的路径
        System.out.println(FilenameUtils.getPath("E:\\45\\4\\123.txt\\123.txt"));
        // 转换分隔符为当前系统分隔符
        System.out.println(FilenameUtils.separatorsToSystem("E:\\45\\4\\123.txt\\123.txt"));
    }

    @Test
    //TeeInputStream，将InputStream以及OutputStream作为参数传入其中，自动实现将输入流的数据读取到输出流中。
    public void test() throws IOException {
        // XmlStreamReader
        File xml = new File("E:\\test.xml");
        XmlStreamReader xmlReader = new XmlStreamReader(xml);
        System.out.println("XML encoding: " + xmlReader.getEncoding());
        String INPUT = "This should go to the output.";
        // TeeInputStream
        ByteArrayInputStream in = new ByteArrayInputStream(INPUT.getBytes("US-ASCII"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TeeInputStream tee = new TeeInputStream(in, out, true);

        tee.read(new byte[INPUT.length()]);
        System.out.println("Output stream: " + out.toString());

    }


    @Test
    //TeeOutputStream，它可以将输出流进行分流，可以用一个输入流将数据分别读入到两个不同的输出流。
    public void test8() throws IOException {
        String INPUT = "This should go to the output.";
        // TeeOutputStream
        ByteArrayInputStream in = new ByteArrayInputStream(INPUT.getBytes("US-ASCII"));
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        TeeOutputStream teeOut = new TeeOutputStream(out1, out2);
        TeeInputStream teeIn = new TeeInputStream(in, teeOut, true);
        teeIn.read(new byte[INPUT.length()]);
        System.out.println("Output stream 1: " + out1.toString());
        System.out.println("Output stream 2: " + out2.toString());
    }

    @Test
    public void readTest(){
        File file=new File("E:\\123.txt");
        try(InputStream is=new FileInputStream(file)){
            byte[] bytes=new byte[100];
            int len= IOUtils.read(is,bytes);//读入byte数组中
            System.out.println(len);

            List<String> list=IOUtils.readLines(is,StandardCharsets.UTF_8);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void filterTest1(){
        File dir = new File("E:\\45");
        String[] acceptedNames = { "SD.txt", "123.txt" };
        // 匹配文件名,
        for (String file : dir.list(new NameFileFilter(acceptedNames, IOCase.INSENSITIVE))) {
            System.out.println("File found, named: " + file);
        }

    }

    @Test
    public void test1(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("hepengju", 28, 20000.0));
        personList.add(new Person("lisi"    , 44, 40000.0));
        personList.add(new Person("wangwu"  , 55, 50000.0));
        personList.add(new Person("zhaoliu" , 66, 60000.0));
        personList.add(new Person("zhangsan", 33, 33333.0));
        personList.add(new Person("wgr", 23, 10000.0));
        Map<String, Person> collect = personList.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
        for (Map.Entry<String,Person> entry:collect.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }

}
