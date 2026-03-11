import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            double height = sc.nextDouble();
            double weight = sc.nextDouble();
            double result = weight / (height*height);
            System.out.print("BMI:"+result);
        }catch(Exception e){
            System.err.println("ERROR!");
        }
	}
}