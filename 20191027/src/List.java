import com.sun.glass.ui.Size;

import java.util.Arrays;
import java.util.SortedMap;

class List {
    public int usedSize;
    public int[] elem;
    public final int CAPACITY = 10;
    public List(){
        this.elem=new int[CAPACITY];
        this.usedSize=0;
    }

    // 在 pos 位置新增元素
     public void add(int pos, int data) {
        //1.判断pos是否合法
         //2.挪数据
         //3.插入数据
         //4.usedSize++
         if(usedSize==elem.length) {
             this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
             //this.elem=new int[elem.length*2];
//             for (int i=0;i<elem.length;i++){
//                 this.elem[i]=elem[i];
//             }
             //this.usedSize=usedSize;
         }else if(pos>=0&&pos<=usedSize){
                 int size=usedSize;
                 while(pos<size){
                     this.elem[size]=this.elem[size-1];
                     size--;
                 }
                 this.elem[pos]=data;
                 usedSize++;
         }else{
             System.out.println("输入不合法");
             return;
         }
     }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i=0;i<this.elem.length;i++){
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i=0;i<this.elem.length;i++){
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos>=0&&pos<=usedSize){
            return elem[pos];
        }else{
            System.out.println("位置不合法！");
            return -1;
        }

    }
    // 给 pos 位置的元素设为 value
    // public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(this.usedSize==0){
            System.out.println("顺序表为空，无法删除");
            return;
        }
        //int b=Arrays.binarySearch(this.elem,toRemove);
        //System.out.println(Arrays.binarySearch(this.elem,toRemove));
        int a=search(toRemove);
        if(a<0){
            System.out.println("无法查找到");
            return;
        }
        while (a<this.usedSize-1){
            this.elem[a]=this.elem[a+1];
            a++;
        }
        //elem[a]=0;
        usedSize--;
    }
    // 获取顺序表长度
    public int size() {

        return usedSize;
    }
    // 清空顺序表
    public void clear() {
        for(int i=0;i<elem.length;i++){
            elem[i]=0;
        }
    }
    // 打印顺序表
    public void display() {
        for(int i=0;i<this.usedSize;i++){
            System.out.printf("%d ",elem[i]);
        }
        System.out.println();
    }

}
