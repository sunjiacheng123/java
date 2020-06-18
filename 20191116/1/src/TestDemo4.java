import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 10:02
 */
//自定义类型进行排序 implements Comparable<Student>
    //重写compareTo方法的返回值类型（三种）
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
        //return (int)(this.score - o.score);
        //return this.name.compareTo(o.name);
    }
}
/**
 * Cloneable了解吗？  当中 没有抽象方法
 * 空接口:标记接口-》标志当前类可以进行克隆
 */
class Money implements Cloneable{
    double m  = 12.9;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    Money money;
    public Person() {

    }
    public Person (String name) {
        this.name = name;
        this.money = new Money();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.money = (Money) this.money.clone();
        //return super.clone();
        return p;
    }
}

public class TestDemo4 {
    public static void main3(String[] args) throws CloneNotSupportedException {
        Person person = new Person("caocao");
        Person person2 = (Person) person.clone();
        person2.money.m = 99.99;
        System.out.println(person.money.m);
        System.out.println(person2.money.m);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.name = "caocao";
        System.out.println(person.name);
        System.out.println("clone");
        Person person2 = (Person) person.clone();
        person2.name = "liubei";
        System.out.println(person.name);
        System.out.println(person2.name);
    }


    //传的数据类型  肯定是实现Comparable接口的
    public static void sort(Comparable[] comparables) {
        //冒泡写
        for (int i = 0; i < comparables.length; i++) {
            for (int j = 0; j < comparables.length-1-i; j++) {
                if(comparables[j].compareTo(comparables[j+1]) > 0) {
                    Comparable tmp = comparables[j + 1];
                    comparables[j  + 1] = comparables[j];
                    comparables[j] = tmp;
                }
            }
        }
    }

    public static void main1(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("liubei",78,97.6);;
        students[1] = new Student("caocao",48,186.9);
        students[2] = new Student("ahangfei",98,100.8);;
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        sort(students);
        System.out.println(Arrays.toString(students));
    }
}
