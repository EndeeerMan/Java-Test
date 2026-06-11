import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;


public class DatabaseReader {
    public static void list(){
        list(PublicScanner.sc);
    }

    public static void list(Scanner sc){
        try(BufferedReader fread = new BufferedReader(new FileReader(".\\database_store\\database.csv",StandardCharset.UTF_8))){
            String line;

            System.out.println("==========================");
            System.out.println("【1】信息概要");
            System.out.println("【2】列出学生所有信息");
            System.out.println("【3】列出学生单个科目信息");
            System.out.println("【4】列出所有学生信息概要");
            System.out.println("==========================");
            System.out.print("请输入选项：");

            int detailed_info_switch = sc.nextInt();
            sc.nextLine();

            switch (detailed_info_switch) {
                case 1 -> {
                    System.out.print("请输入你需要查询的学生的学号：");
                    String target_row = sc.next();

                    boolean flag = false;

                    while((line = fread.readLine()) != null){
                        int counter = 1;
                        
                        String[] line_data = line.split(",");
                        
                        for(String buf : line_data){
                            if(counter == 1 && buf.equals(target_row) == false){
                                break;
                            }
                            if(counter == 1) System.out.print("当前学生的 学号 姓名 评分：" + buf + " ");
                            if(counter == 2) System.out.print(buf + " ");
                            if(counter == 3) System.out.println(buf);
                            if(counter == 4){
                                System.out.println("该条数据最后一次修改时间：" + buf);
                                flag = true;
                                break;
                            }
                            counter++;
                        }
                    }
                    if(flag == false){
                        System.out.println("学号不存在或数据不完整！");
                    }
                    break;
                }

                case 2 -> {
                    System.out.print("请输入你需要查询的学生的学号：");
                    String target_row = sc.next();
                    boolean flag = false;
                    while((line = fread.readLine()) != null){
                        int counter = 1;
                        
                        String[] line_data = line.split(",");

                        for(String buf : line_data){
                            if(counter == 1 && buf.equals(target_row) == false){
                                break;
                            }
                            if(counter == 1)System.out.print("当前学生的 学号 姓名 评分：" + buf + " ");
                            if(counter == 2) System.out.print(buf + " ");
                            if(counter == 3) System.out.println(buf);
                            if(counter == 4){
                                System.out.println("该条数据最后一次修改时间：" + buf);
                                flag = true;
                            }
                            if(counter == 5) System.out.println("以下是该学生每个学科学分以及完成比例：");
                            if(counter > 4 && counter % 3 == 2) System.out.print("学科 " + buf + " ：");
                            if(counter > 4 && counter % 3 == 0) System.out.print(buf + " ");
                            if(counter > 4 && counter % 3 == 1){
                                System.out.println(buf);
                            }
                            
                            counter++;
                        }
                    }
                    if(flag == false){
                        System.out.println("学号不存在或数据不完整！");
                    }
                    break;
                }
                
                case 3 -> {
                    System.out.print("请输入你需要查询的学生的学号：");
                    String target_row = sc.next();
                    System.out.print("请输入目标科目编号：");
                    String subject_num = sc.next();
                    boolean student_found = false;
                    boolean subject_found = false;

                    while((line = fread.readLine()) != null){
                        int counter = 1;
                        
                        String[] line_data = line.split(",");
                        
                        for(String buf : line_data){
                            if(counter == 1 && buf.equals(target_row) == false){
                                break;
                            }
                            if(counter == 1) {
                                System.out.print("当前学生的 学号 姓名 评分：" + buf + " ");
                                student_found = true;
                            }
                            if(counter == 2) System.out.print(buf + " ");
                            if(counter == 3) System.out.println(buf);
                            if(counter == 4) System.out.println("该条数据最后一次修改时间：" + buf);
                            if(counter == 5) System.out.println("以下是该学生学科学分以及完成比例：");
                            if(counter > 4 && counter % 3 == 2 && buf.equals(subject_num)){
                                System.out.print("学科 " + buf + " ：");
                                subject_found = true;
                            }
                            if(counter > 4 && counter % 3 == 0 && subject_found == true) System.out.print(buf + " ");
                            if(counter > 4 && counter % 3 == 1 && subject_found == true){
                                System.out.println(buf);
                                break;
                            }
                            counter++;
                        } 
                    }
                    if(!student_found){
                        System.out.println("学号不存在或数据不完整！");
                    } else if(!subject_found) {
                        System.out.println("该学生没有此科目！");
                    }
                    break;
                }

                case 4 ->{
                    System.out.println("所有学生的 学号 姓名 评分 最后一次修改时间 如下：");
                    while((line = fread.readLine()) != null){
                        int counter = 1;
                        
                        String[] line_data = line.split(",");

                        for(String buf : line_data){
                            if(counter == 1) System.out.print(buf + "\t\t");
                            if(counter == 2) System.out.print(buf + "\t\t");
                            if(counter == 3) System.out.print(buf + "\t\t");
                            if(counter == 4){
                                System.out.println(buf);
                                break;
                            }
                            counter++;
                        }
                    }
                    break;
                }
                default -> System.out.println("没有此选项！");
            }
        }catch(IOException e) {
            System.err.println("文件读写错误！");
        }catch(InputMismatchException e){
            System.err.println("输入数据格式有误！");
        }catch(Exception e){
            System.err.println("其他错误！");
        }
    }
}