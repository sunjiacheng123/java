public class ThreadLambda {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,world!!!!!");
            }
        }).start();

        //创建线程的lambda表达式
        new Thread(()-> System.out.println("hello,world!!")).start();

        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("46546");
            }
        };
        Runnable r1=()-> System.out.println("lambda练习");
        r.run();
        r1.run();
    }
}
