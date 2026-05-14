import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /********** Begin **********/
        // 创建一个Date对象，通过输入的毫秒值作为构造方法的实参
        Scanner scanner = new Scanner(System.in);
        long milliseconds = scanner.nextLong();
        Date date = new Date(milliseconds);

        // 创建一个DateFormat对象，设置日期格式为yyyy-MM-dd HH:mm:ss
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 使用DateFormat对象的format()方法将Date对象格式化成指定的日期字符串
        String formattedDate = dateFormat.format(date);

        // 将格式化后的日期字符串输出到控制台
        System.out.println(formattedDate);

        /********** End **********/
    }
}
