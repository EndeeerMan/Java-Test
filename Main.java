
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int switch_num = 1;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("欢迎使用学生评分管理系统！");
            System.out.println("以下为选项菜单：");
            
            while(switch_num != 0){
                System.out.println("========================");
                System.out.println("【1】读取数据库数据");
                System.out.println("【2】改变数据库数据");
                System.out.println("【0】退出系统");
                System.out.println("========================");
                System.out.print("请输入你的选项：");

                switch_num = sc.nextInt();
                sc.nextLine();

                switch(switch_num){
                    case 1 ->{
                        DatabaseReader.list(sc);
                    }
                    case 2 ->{
                        DatabaseModifierMenu.Menu(sc);
                    }
                    case 0 ->{
                        System.out.println("感谢您使用本系统，下次再见！");
                        System.exit(0);
                    }
                }
            }
        }catch(InputMismatchException e){
            System.err.println("输入格式错误！");
        }
    }
}
