import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class biSearchRe {
    public static int BiSRe(int[] arry, int pl, int pr, int key){
        if(pl <= pr){
            int pc = (pl+pr)/2;
            if(arry[pc] < key){
                return BiSRe(arry, pc+1, pr, key);
            }else if(arry[pc] > key){
                return BiSRe(arry, pl, pc-1, key);
            }else{
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
            sc.close();
            int n = arry.length;
            int result = BiSRe(arry,0, n - 1, key);
        
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