import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /********** Begin **********/
        Scanner sc = new Scanner(System.in);
        // 定义一个整型数组，包含10个元素
        int[] arr = new int[10];

        // 使用for循环给数组的元素赋值，数值由键盘输入
        for(int i=0;i<10;i++){
            arr[i] = sc.nextInt();
        }

        // 使用for循环遍历数组，计算数组中所有元素的和并输出结果
        int sum = 0;
        for(int i=0;i<10;i++){
            sum += arr[i];
        }
        System.out.println("数组中所有元素的和为：" + sum);
        sc.close();
        /********** End **********/
    }
}
