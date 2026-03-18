import java.util.Scanner;
import java.util.InputMismatchException;

public class Test {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("请猜1到10的数字：");
            int num = sc.nextInt();
            int guess = 0;
            for(int i=1;i<=5;i++){
                guess = sc.nextInt();
                if(num > guess){
                    System.out.println("小了！再试试吧。");
                    continue;
                }else if(num < guess){
                    System.out.println("大了！再试试吧。");
                    continue;
                }else if(num == guess){
                    System.out.println("恭喜你，猜对了！这个数字就是"+num);
                    System.out.print("你总共猜了"+i+"次");
                    return;
                }
            }
            System.out.print("很遗憾，5次机会都没有猜中！");
        }catch(InputMismatchException E){
            System.err.println("InputMismatchException E !");
        }
    }
}
