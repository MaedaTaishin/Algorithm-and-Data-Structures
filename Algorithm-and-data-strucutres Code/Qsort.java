import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class Qsort {
    public static void main(String[] args){
        try{
            Path file = Paths.get ("testdata-sort-4.txt");
            List<String> stringData = Files.readAllLines(file);
        
            int[] arry = new int[stringData.size()];
            for (int i = 0; i<arry.length; i++){
                arry[i] = Integer.parseInt(stringData.get(i));
            }
            int n = arry.length;
            long start = System.nanoTime();
            quick(arry, 0, n - 1);
            long end = System.nanoTime();
            System.out.println("Sorted Array: ");
            printArry(arry);
            System.out.println("Execution time: " + (end - start)/1e6 + " milliseconds.");

        }catch (IOException e){
            e.printStackTrace();
        }   
    }
    private static void quick(int[] arry, int left, int right){
       int pl = left;
       int pr = right;
       int pivot = arry[(pl+pr)/2];
       while(pl <= pr){
            while (arry[pl] < pivot){
                pl++;
            }
            while(arry[pr] > pivot){
                pr--;
            }
            if(pl <= pr){
                swap(arry, pl, pr);
                pl++;
                pr--;
            }
        }   
        if(left < pr){
            quick(arry, left, pr);
        }
        if(right > pl){
            quick(arry, pl, right);
        }
    }     
    private static void swap(int[] arry, int x, int y){
        int temp = arry[x];
        arry[x] = arry[y];
        arry[y] = temp;
    }
    private static void printArry(int[] arry){
        for(int i=0; i<arry.length; i++){
            System.out.println("x[" + i + "]=" + arry[i]);
        }
        System.out.println();
    }
}
