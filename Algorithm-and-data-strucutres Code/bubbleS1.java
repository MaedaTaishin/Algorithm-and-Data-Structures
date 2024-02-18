import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class bubbleS1 {
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
            bubS1(arry, n);
            long end = System.nanoTime();
            //System.out.println("Sorted Array: ");
            //printArry(arry);
            System.out.println("Execution time: " + (end - start)/1e6 + " milliseconds.");

        }catch (IOException e){
            e.printStackTrace();
    }   }
    private static void bubS1(int[] arry, int n){
        for(int i=0; i<=n-2; i++){
            int exchg = 0;
            for(int j=n-1; j>=i+1; j--){
                if(arry[j-1] > arry[j]){
                    swap(arry, j);
                    exchg += 1;
                }
            }
            if(exchg == 0){
                break;
            }
        }
    }
    private static void swap(int[] arry, int j){
        int temp = arry[j];
        arry[j] = arry[j-1];
        arry[j-1] = temp;
    }
    /*private static void printArry(int[] arry){
        for(int i=0; i<arry.length; i++){
            System.out.println("x[" + i + "]=" + arry[i]);
        }
        System.out.println();
    }*/
    
}
