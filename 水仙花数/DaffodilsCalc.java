public class DaffodilsCalc {
    public int Calc(int num){
        int num1 = num%10;
        int num2 = (num/10)%10;
        int num3 = num/100;
        if(num == num1*num1*num1 + num2*num2*num2 + num3*num3*num3) return 1;
        return 0;
    }
}
