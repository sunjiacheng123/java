/*



*/


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str=in.next();
        //str.toCharArray();
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i] >= 65 && ch[i] < 97){
                ch[i]= (char) (ch[i]+32);
            }
        }
        System.out.println(new String(ch));
    }

}
