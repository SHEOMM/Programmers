import java.util.*;

class Solution {
    
    private Map<String, Integer> clothType = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        for(String[] clotheArr: clothes){
            String type = clotheArr[1];
            String clothe = clotheArr[0];
            if(clothType.containsKey(type)){
                clothType.put(type, clothType.get(type) + 1);
            }else{
                clothType.put(type, 1);
            }
        
        }
        for(String type: clothType.keySet()){
            answer *= clothType.get(type) + 1;
        }
        
        answer -= 1;
        return answer;
    }
}