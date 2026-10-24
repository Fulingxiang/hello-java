import java.util.Scanner;

public class ScannerText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int  x = sc.nextInt();
        int  y = sc.nextInt();

        int sum = x+y ;
        System.out.println(sum);*/
        String s = sc.nextLine();
        String t = sc.nextLine();
        String p = s+t;
        System.out.println(p);
    }
}