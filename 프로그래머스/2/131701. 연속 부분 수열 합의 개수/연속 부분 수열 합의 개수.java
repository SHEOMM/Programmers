import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        Set<Integer> sums = new HashSet<>();
        for(int i = 1; i <= length; i++){
        
            for(int j = 0; j < length; j++){
                int sum = 0;
                for(int k = j; k < j + i; k++){
                    sum += elements[convertIndex(k, length)];
                }   
                sums.add(sum);
            }
        }
        return sums.size();
    }
    
    private int convertIndex(int index, int length){
        return index % length;
    }
}