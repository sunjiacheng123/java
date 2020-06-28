/*
*对于基础类型的参数，不能通过改变形参来修改实参
* 方法：1.将基础类型的变量放入数组中
* 2.重新封装一种行的类型，然后将变量放到新封装的类型中
* */

import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;

public class Text {
    public void  Swap(Number num){
        int tmp=num.left;
        num.left=num.right;
        num.right=tmp;
    }

    public static void main(String[] args) {
        Number num =new Number(left,right);

    }
}
