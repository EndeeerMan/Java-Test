import java.util.InputMismatchException;
import java.util.Scanner;

public class DatabaseModifierMenu {
    public static void Menu(){
        Menu(PublicScanner.sc);
    }

    public static void Menu(Scanner sc){
            System.out.println("========================");
            System.out.println("【1】增加一个学生");
            System.out.println("【2】增加指定学生的科目");
            System.out.println("【3】删除指定学生");
            System.out.println("【4】删除指定学生的指定科目");
            System.out.println("【5】修改指定学生的指定科目");
            System.out.println("【6】修改指定学生的基本信息");
            System.out.println("========================");
            System.out.print("请输入你的选项：");
        try{
            int switch_num = sc.nextInt();
            sc.nextLine();
            switch(switch_num){
                case 1 -> {
                    DatabaseModifier.add_one_stu(sc);
                }
                case 2 -> {
                    DatabaseModifier.add_one_subject(sc);
                }
                case 3 -> {
                    DatabaseModifier.del_a_student(sc);
                }
                case 4 -> {
                    DatabaseModifier.del_a_subject(sc);
                }
                case 5 -> {
                    DatabaseModifier.modify_a_subject(sc);
                }
                case 6 -> {
                    DatabaseModifier.modify_a_student(sc);
                }
                default -> {
                    System.out.println("输入选项错误！");
                }
            }
        }catch(InputMismatchException e){
            System.err.println("输入格式错误！");
        }
    }
}
