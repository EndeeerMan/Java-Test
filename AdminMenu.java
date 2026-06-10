import java.util.InputMismatchException;


public class AdminMenu {
    public static void Menu() {
        int switch_num = 1;
        try{
            System.out.println("欢迎使用学生评分管理系统（管理员菜单）！");
            System.out.println("以下为选项菜单：");
            
            while(switch_num != 0){
                System.out.println("========================");
                System.out.println("【1】读取数据库数据");
                System.out.println("【2】改变数据库数据");
                System.out.println("【0】退出管理员状态");
                System.out.println("========================");
                System.out.print("请输入你的选项：");

                switch_num = PublicScanner.sc.nextInt();
                PublicScanner.sc.nextLine();

                switch(switch_num){
                    case 1 ->{
                        DatabaseReader.list(PublicScanner.sc);
                    }
                    case 2 ->{
                        DatabaseModifierMenu.Menu(PublicScanner.sc);
                    }
                    case 0 ->{
                        System.out.println("退出管理员状态！");
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
