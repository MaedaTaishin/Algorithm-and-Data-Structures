import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class binarySearch {
    public static int BiS(int [] arry, int n, int key){
        int pl = 0;
        int pr = n - 1;
        while(pl<=pr){
            int pc = (pl + pr) / 2;
            if(arry[pc] < key){
                pl = pc + 1;
            }else if(arry[pc] > key){
                pr = pc - 1;
            }else if (arry[pc] == key){
                return pc;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            Path file = Paths.get ("testdata-search.txt");
            List<String> stringData = Files.readAllLines(file);
        
            int[] arry = new int[stringData.size()];
            for (int i = 0; i<arry.length; i++){
                arry[i] = Integer.parseInt(stringData.get(i));
            }
            System.out.println("Input a key: ");
            int key = sc.nextInt();
            int n = arry.length;
            int result = BiS(arry,n,key);
        
            if(result == -1){
                System.out.println("The element not found");
            }else{
                System.out.println("The element found at array "+ result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }   
}