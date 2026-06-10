import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;


public class Password {  
    public static void Set(){
        try(BufferedReader fread = new BufferedReader(new FileReader(".\\password"))){
            String old_MD5_pwd = fread.readLine();

            if(old_MD5_pwd != null){
                System.out.print("请输入旧密码：");
                String old_pwd = PublicScanner.sc.nextLine();

                if(!InputDataCheck.isPassword(old_pwd)){
                    System.out.println("密码格式不正确！");
                    return;
                }

                if(Validate_pwd.Verify(old_pwd, old_MD5_pwd) == false){
                    System.out.println("旧密码输入错误！");
                    return;
                }
            }else{
                System.out.println("没有设置密码！");
            }

            System.out.print("请输入新密码：");
            String new_pwd = PublicScanner.sc.nextLine();

            if(!InputDataCheck.isPassword(new_pwd)){
                System.out.println("密码格式不正确！");
                return;
            }

            Write_Password.Write(new_pwd);
            System.out.println("密码设置完成！");
            
        }catch(IOException e){
            System.err.println("密码文件读写错误！");
        }catch(InputMismatchException e){
            System.err.println("输入格式错误！");
        }catch(Exception e){
            System.err.println("其他错误！");
        }
    }

    public static boolean Verify(){
        try(BufferedReader fread = new BufferedReader(new FileReader(".\\password"))){
            String old_MD5_pwd = fread.readLine();
            if(old_MD5_pwd == null){
                Password.Set();
                return true;
            }
            
            System.out.print("请输入密码：");
            String pwd = PublicScanner.sc.nextLine();
            return Validate_pwd.Verify(pwd, old_MD5_pwd);
        }catch(IOException e){
            throw new IllegalStateException("密码文件读写错误！",e);
        }
    }
}

class Write_Password{
    public static void Write(String new_pwd){
        try(BufferedWriter fprint = new BufferedWriter(new FileWriter(".\\password"))){
            fprint.append(Encrypt.Compute(new_pwd));
        }catch(IOException e) {
            System.out.println("密码文件读写错误！");
        }
    }
}

class Validate_pwd{
    public static boolean Verify(String pwd, String MD5_pwd){
        if(pwd == null || MD5_pwd == null){
            return false;
        }
        return MD5_pwd.equals(Encrypt.Compute(pwd));

    }
}

class Encrypt{
    public static String Compute(String pwd){
        if(pwd == null){
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(pwd.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            
            for(byte buf : messageDigest){
                //将byte格式化为两位，以确保数据不错位
                hexString.append(String.format("%02x", buf));
            }
            return hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("不存在MD5算法！",e);
        }
    }
}
