import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class bubbleS2 {
    public static void main(String[] args){
        try{
            Path file = Paths.get ("testdata-sort-2.txt");
            List<String> stringData = Files.readAllLines(file);
        
            int[] arry = new int[stringData.size()];
            for (int i = 0; i<arry.length; i++){
                arry[i] = Integer.parseInt(stringData.get(i));
            }
            int n = arry.length;
            long start = System.currentTimeMillis();
            bubS2(arry, n);
            long end = System.currentTimeMillis();
            //System.out.println("Sorted Array: ");
            //printArry(arry);
            System.out.println("Execution time: " + (end - start));

        }catch (IOException e){
            e.printStackTrace();
        }   }
    private static void bubS2(int[] arry, int n){
        int k = 0;
        while(k < n-1){
            int last = n-1;
            for(int j=n-1; j>=k+1; j--){
                if(arry[j-1] > arry[j]){
                    swap(arry, j);
                    last = j;
                }
            }
            k = last;
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
