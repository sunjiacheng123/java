/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-10-27
 * Time: 9:49
 */
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
public class TestDemo2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10.0);
        calculator.setNum2(5.0);

        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
        System.out.println("===========");
        Calculator calculator2 = new Calculator(9.0,3.0);

        System.out.println(calculator2.add());
        System.out.println(calculator2.sub());
        System.out.println(calculator2.mul());
        System.out.println(calculator2.div());
    }
}
