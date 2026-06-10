import java.util.Scanner;

public class PublicScanner {
    //建立公共Scanner，防止在其他类里关闭导致System.in流死亡
    public static final Scanner sc = new Scanner(System.in);
}
