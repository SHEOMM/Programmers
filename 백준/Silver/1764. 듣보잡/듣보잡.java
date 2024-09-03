import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
        Set<String> noListens = new HashSet<>();
        List<String> answer = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] parsedFirstLine = br.readLine().split(" ");
            int N = Integer.parseInt(parsedFirstLine[0]);
            int M = Integer.parseInt(parsedFirstLine[1]);
            
            for(int i = 0; i<N; i++){
                noListens.add(br.readLine());
            }
            
            for(int i = 0; i<M; i++){
                String noLook = br.readLine();
                if(noListens.contains(noLook)){
                    answer.add(noLook);
                }
            }
            System.out.println(answer.size());
            Collections.sort(answer);
            for(String noLookAndListen: answer){
                System.out.println(noLookAndListen);
            }
       
            
        }catch(Exception e){
            return;
        }
    }
}