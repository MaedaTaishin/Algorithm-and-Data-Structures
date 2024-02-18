import java.util.Scanner;
public class TowerH {
    static void move(int n, int x, int y){
        if(n >= 1){
            move(n - 1, x, 6 - x - y);
            System.out.println("move disk ["+n+"] from "+x+" to "+y);
            move(n - 1, 6 - x - y, y);
        }
    }
    static int step(int n){
        if(n >=1){
            return 2 * step(n - 1) + 1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tower of Hanoi");
        System.out.print("The number of disk: ");
        int num = sc.nextInt();
        sc.close();
        long start = System.nanoTime();
        move(num, 1, 3);
        long end = System.nanoTime();
        System.out.println(step(num) + " steps required");
        System.out.println("Execution time: " + (end - start)/1e6 + "milliseconds");
    }
}
