import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
        
        try{
            
        
        Set<String> set = new HashSet<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String setNumbers = br.readLine();
        String[] parsedNums = setNumbers.split(" ");
        for(String str: parsedNums){
            set.add(str);
        }
        
        br.readLine();
        String input = br.readLine();
        String[] inputParsed = input.split(" ");
        
        for(String str: inputParsed){
            if(set.contains(str))
                System.out.println("1");
            else
                System.out.println("0");
        }
        }catch(Exception e){
            return;
        }
    }
}