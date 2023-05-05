import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int answer = 0;
        for(int food : scoville){
            minHeap.add(food);
        }
        
        while(true){
            if(!minHeap.isEmpty()){
                int min = minHeap.poll();
            if(min >= K)
                break;
            if(!minHeap.isEmpty()){
                int second = 2 * minHeap.poll();
            minHeap.add(min + second);
            answer++;
            }else{
                return -1;
            }
            
            }else{
                return -1;
            }
            
        }
        return answer;
    }
}