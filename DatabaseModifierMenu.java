import java.util.InputMismatchException;
import java.util.Scanner;

public class DatabaseModifierMenu {
    public static void Menu(){
        Menu(new Scanner(System.in));
    }

    public static void Menu(Scanner sc){
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
