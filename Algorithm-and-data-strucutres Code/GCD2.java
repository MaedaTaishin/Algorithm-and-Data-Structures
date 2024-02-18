import java.util.Scanner;
public class GCD2 {
    static int gcd(int x, int y){
        if(y==0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }
    static int gcdArr(int[] a, int start, int no){
        if(no == 1){
            return a[start];
        }else if(no == 2){
            return gcd(a[start], a[start + 1]);
        }else{
            return gcd(a[start], gcdArr(a, start + 1, no - 1));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many intergers: ");
        int num = sc.nextInt();
        int [] x = new int[num];
        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("GCD: " + gcdArr(x, 0, num));
    }
}
