import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(Integer num : arr){
            if (answer >= num){
                return answer;
            }
            answer++;
        }
        return answer;
    }
}