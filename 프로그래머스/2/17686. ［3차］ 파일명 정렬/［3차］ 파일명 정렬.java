import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        File[] input = new File[files.length];
        for(int i = 0; i<files.length; i++){
            input[i] = new File(files[i]);
        }
        Arrays.sort(input);

        String[] answer = new String[files.length];
        for(int i = 0; i<answer.length; i++){
            answer[i] = input[i].fullName;
        }
        return answer;
    }
}

class File implements Comparable<File>{
    
    String fullName;
    String head;
    int number;
    String tail;
    
    public File(String input){
        fullName = input;
        char[] inputChars = input.toCharArray();
        int idx = 0;
        for(; idx < inputChars.length; idx++){
            if(Character.isDigit(inputChars[idx])){
                break;
            }
           
        }
        head = input.substring(0, idx);
        int numStart = idx;
        for(; idx< inputChars.length; idx++){
            if(!Character.isDigit(inputChars[idx])){
                break;
            }
            number += inputChars[idx];
        }
        number = Integer.parseInt(input.substring(numStart, idx));
        tail = input.substring(idx);
    }
    
    @Override
    public int compareTo(File f){
        int headCompare = this.head.compareToIgnoreCase(f.head);
        if(headCompare > 0){
            return 1;
        } else if(headCompare == 0){

            if(this.number > f.number)
                return 1;
            else if(this.number == f.number)
                return 0;
            else
                return -1;
        }else{
            return -1;
        }
        
    }
    
    @Override
    public String toString(){
        return "head: " + head + "\n" + "number: " + number + "\n" + "tail: " + tail + "\n";
    }
}