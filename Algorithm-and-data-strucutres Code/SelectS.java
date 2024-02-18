import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class SelectS {
    public static void main(String[] args){
        try{
            Path file = Paths.get ("testdata-sort-3.txt");
            List<String> stringData = Files.readAllLines(file);
        
            int[] arry = new int[stringData.size()];
            for (int i = 0; i<arry.length; i++){
                arry[i] = Integer.parseInt(stringData.get(i));
            }
            int n = arry.length;

            long start = System.nanoTime();
            selectS(arry,n);
            long end = System.nanoTime();

            //System.out.println("Sorted Array: ");
            //printArry(arry);

            System.out.println("Execution time: " + (end - start)/1e6 + " milliseconds.");
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void selectS(int[] arry, int n){
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arry[j] < arry[min]){
                    min = j;
                }
            }
            int temp = arry[min];
            arry[min] = arry[i];
            arry[i] = temp;
        }
    }
    /*private static void printArry(int[] arry){
        for(int i=0; i<arry.length; i++){
            System.out.println("x[" + i + "]=" + arry[i]);
        }
        System.out.println();
    }*/
}
