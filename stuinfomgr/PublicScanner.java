import java.util.Scanner;

public class PublicScanner {
    //建立公共Scanner，防止在其他类里关闭导致System.in流死亡
    public static final Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}