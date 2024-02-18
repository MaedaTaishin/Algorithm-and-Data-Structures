import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class bfSearch {
    public static int bfS(String text, String pattern){
        int pt = 0;
        int pp = 0;

        while(pt != text.length() && pp != pattern.length()){
            if(text.charAt(pt) == pattern.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt -= pp - 1;
                pp = 0;
            }
        }
        if(pp == pattern.length()){
            return pt - pp;
        }else{
            return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            Path file = Paths.get ("testdata-stringsearch.txt");
            List<String> stringData = Files.readAllLines(file);
        
            System.out.println("Pattern: ");
            String pattern = sc.nextLine();
            sc.close();
            int line = -1;
            int result = -1;
            for(int i=0; i<stringData.size(); i++){
                int temp = bfS(stringData.get(i), pattern);
                if(temp != -1){
                    line = i;
                    result = temp;
                    break;
                }
            }
        
            if(result == -1){
                System.out.println("There is no pattern found!");
            }else{
                int len = result + pattern.length();
                System.out.println("Matched at "+ (result + 1) + " in line " + (line + 1));
                System.out.println(stringData.get(line));
                System.out.printf(String.format("%%%ds\n", len), pattern);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }   
}