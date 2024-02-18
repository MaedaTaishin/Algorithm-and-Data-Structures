import java.util.Scanner;
public class GCD1 {
    static int gcd(int x, int y){
        if(y==0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("GCD of two integers");
        System.out.print("Input an integer: ");
        int x = sc.nextInt();
        System.out.print("Input another integer: ");
        int y = sc.nextInt();
        sc.close();
        System.out.println("GCD: " + gcd(x, y));
    }
}
