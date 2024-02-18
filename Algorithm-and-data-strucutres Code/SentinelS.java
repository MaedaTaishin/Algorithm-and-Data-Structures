import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
public class SentinelS {
    public static int senSeqSearch(int[] a, int n, int x) {
        int[] arryS = new int[n+1];
        System.arraycopy(a, 0, arryS, 0, n);
        arryS[n] = x;

        int i = 0;
        while (arryS[i]!=x) {
            i++;
        }
        if (i<n && arryS[i]==x) {
            return i;
        } else {
        return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
        try {
            Path file = Paths.get ("test-data-10.txt");
            List<String> stringData = Files.readAllLines(file);

            int[] arry = new int[stringData.size()];
            for (int i = 0; i<arry.length; i++){
                arry[i] = Integer.parseInt(stringData.get(i));
            }
            for (int i = 0; i<arry.length; i++){
                System.out.print(arry[i]+ " ");
            }

            System.out.println();
            System.out.println("Enter an element: ");
            int x = sc.nextInt();
            int n = arry.length;
            int index = senSeqSearch(arry, n, x);
            if (index == -1){
                System.out.println("The element not found");
            }else{
                System.out.println("The element found in array "+ index);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
