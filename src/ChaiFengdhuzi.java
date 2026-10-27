import java.util.Scanner;

public class ChaiFengdhuzi {
    //拆分一个三位数
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*int a,b,c,number;
        System.out.println("请输入一个三位数：");
        number = sc.nextInt();
        //个位
        a=number%10;
        //十位
        b=number/10%10;
        //百位
        c=number/100%10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);*/
        //时间转换，将时间转换为小时，分钟，秒；
        int time,hour,minute,second;
        System.out.println("请输入一个时间：");
        time = sc.nextInt();

        //小时
        hour = time/3600;
        minute = time%3600/60;
        second = time%3600%60;
        System.out.println(hour+":"+minute+":"+second);


    }
}
