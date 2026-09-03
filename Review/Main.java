
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(7);
        BigDecimal b = BigDecimal.valueOf(3);
        BigDecimal sum = a.divide(b,5,RoundingMode.FLOOR);

        System.out.printf("%.100f\n",sum);
    }
}
