import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try{
            int switch_num = 1;
            System.out.println("欢迎使用学生评分管理系统！");
            System.out.println("以下为选项菜单：");

            while(switch_num != 0){
                System.out.println("========================");
                System.out.println("【1】进入访客菜单");
                System.out.println("【2】进入管理员菜单");
                System.out.println("【0】退出系统");
                System.out.println("========================");
                System.out.print("请输入你的选项：");

                switch_num = PublicScanner.sc.nextInt();
                PublicScanner.sc.nextLine();

                switch(switch_num){
                    case 1 ->{
                        GuestMenu.Menu();
                    }
                    case 2 ->{
                        if(Password.Verify()){
                            AdminMenu.Menu();
                        }else{
                            System.out.println("密码是错误的！");
                        }
                    }
                    case 0 ->{
                        System.out.println("再见！");
                        return;
                    }
                    default ->{
                        System.out.println("没有此选项！");
                    }
                }
            }
        }catch(InputMismatchException e){
            System.err.println("输入格式错误！");
        }
    }
}