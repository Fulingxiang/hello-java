import java.util.Scanner;

public class IfDome1 {
    public static void main(String[] args){
        //初始生命200，受到伤害为x，使用技能回复y，x,y皆由键盘输入。人物不会死亡，最少一滴血
        int life = 200;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入收到的伤害：");
        int x = sc.nextInt();
        int hp = life - x;
        if(hp <= 0){
            hp = 1;
        }
    System.out.println("当前血量为:"+hp);

    //计算恢复
        System.out.println("请输入恢复的血量：");
        int y = sc.nextInt();
        hp = hp + y;
        if(hp > life){
            hp = 200;
        }
        System.out.println("当前血量为："+hp);

    }
}
