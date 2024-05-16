import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangMap = new HashMap<>();
        int tanCount = 0;
        
        for(Integer tan: tangerine){
            if(tangMap.containsKey(tan)){
                tangMap.put(tan, tangMap.get(tan)+1);
            }else{
                tangMap.put(tan, 1);
            }
            tanCount++;
        }
        int answer = tangMap.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer tangKey: tangMap.keySet()){
            minHeap.add(tangMap.get(tangKey));
        }
        
        while(k <= tanCount){
            tanCount -= minHeap.poll();
            answer--;
        }
        
        if(k != tanCount){
            answer++;
        }
        
        
        
        return answer;
    }
}