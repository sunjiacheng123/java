/**
 * Created with IntelliJ IDEA.
 * Description: 顺序表的测试类
 * User: GAOBO
 * Date: 2019-10-27
 * Time: 11:16
 */
public class TestDemo4 {

    public static void main(String[] args) {
        MySignalList mySignalList = new MySignalList();
        mySignalList.addLast(1);
        mySignalList.addLast(2);
        mySignalList.addLast(3);
        mySignalList.addLast(4);
        mySignalList.display();
        mySignalList.addIndex(0,19);
        mySignalList.display();
        mySignalList.addIndex(5,29);
        mySignalList.display();
        mySignalList.addIndex(1,99);
        mySignalList.display();
        /*System.out.println(mySignalList.contains(3));
        System.out.println(mySignalList.contains(13));

        System.out.println(mySignalList.getLength());*/


    }

    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(1,4);
        myArrayList.add(0,5);
        myArrayList.display();//5 3 4 2 1
        myArrayList.remove(5);
        myArrayList.display();
        myArrayList.remove(1);
        myArrayList.display();
        myArrayList.remove(4);
        myArrayList.display();
        System.out.println("==============");
        myArrayList.clear();
        myArrayList.display();

    }
}
