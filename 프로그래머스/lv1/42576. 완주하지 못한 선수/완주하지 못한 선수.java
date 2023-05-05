import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completor = new HashMap<>();
        for(String complete : completion){
            completor.put(complete, completor.getOrDefault(complete, 0) + 1);
        }
        for(String join : participant){
            if(!completor.containsKey(join)){
                return join;
            }
            int a = completor.get(join);
            if(a == 0){
                return join;
            }else{
                completor.replace(join, a-1);
            }
        }
        return answer;
    }
}