import java.util.InputMismatchException;

public class AdminMenu {
    public static void menu() {
        int switchNum = 1;
        try{
            System.out.println("欢迎使用学生评分管理系统（管理员菜单）！");
            System.out.println("以下为选项菜单：");
            
            while(switchNum != 0){
                System.out.println("========================");
                System.out.println("【1】读取数据库数据");
                System.out.println("【2】改变数据库数据");
                System.out.println("【3】修改管理员密码");
                System.out.println("【4】删除管理员密码");
                System.out.println("【0】退出管理员状态");
                System.out.println("========================");
                System.out.print("请输入你的选项：");

                switchNum = PublicScanner.sc.nextInt();
                PublicScanner.sc.nextLine();

                switch(switchNum){
                    case 1 ->{
                        PublicScanner.clearScreen();
                        DatabaseReader.list(PublicScanner.sc);
                    }
                    case 2 ->{
                        PublicScanner.clearScreen();
                        DatabaseModifierMenu.menu(PublicScanner.sc);
                    }
                    case 3 ->{
                        PublicScanner.clearScreen();
                        Password.set();
                    }
                    case 4 ->{
                        PublicScanner.clearScreen();
                        Password.del();
                    }
                    case 0 ->{
                        PublicScanner.clearScreen();
                        System.out.println("退出管理员状态！");
                        return;
                    }
                    default ->{
                        PublicScanner.clearScreen();
                        System.out.println("没有此选项！");
                    }
                }
            }
        }catch(InputMismatchException e){
            System.err.println("输入格式错误！");
        }
    }
}