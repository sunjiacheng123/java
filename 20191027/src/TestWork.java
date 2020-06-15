
class Calculator {
    private double num1;
    private double num2;

    public Calculator() {

    }

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double add() {
        return this.num1+this.num2;
    }
    public double sub() {
        return this.num1-this.num2;
    }
    public double mul() {
        return this.num1*this.num2;
    }
    public double div() {
        return this.num1/this.num2;
    }

}

class MyValue{
    int num;
}


public class TestWork {
    public static void swap2(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.num;
        myValue1.num = myValue2.num;
        myValue2.num = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.num = 10;
        MyValue myValue2 = new MyValue();
        myValue2.num = 20;
        System.out.println(myValue1.num+" "+myValue2.num);
        swap2(myValue1,myValue2);
        System.out.println(myValue1.num+" "+myValue2.num);
    }


    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10.0);
        calculator.setNum2(5.0);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
    }
}
