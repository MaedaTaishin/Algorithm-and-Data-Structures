import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class ShellS {
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
            shellS(arry, n);
            long end = System.nanoTime();
            //System.out.println("Sorted Array: ");
            //printArry(arry);
            System.out.println("Execution time: " + (end - start)/1e6 + " milliseconds.");
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void shellS(int[] arry, int n){
        for(int h=n/2; h>0; h/=2){
            for(int i=h; i<n; i++){
                int tmp = arry[i];
                int j;
                for(j=i-h; j>=0 && arry[j]>tmp; j-=h){
                    arry[j+h] = arry[j];
                }
                arry[j+h] = tmp;
            }
        }
    }
    /*private static void printArry(int[] arry){
        for(int i=0; i<arry.length; i++){
            System.out.println("x[" + i + "]=" + arry[i]);
        }
        System.out.println();
    }*/
}
