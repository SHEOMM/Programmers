import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i : works){
            maxHeap.add(i);  
        }
        for(int i =0; i<n; i++){
            int num = maxHeap.poll();
            if(num == 0){
                maxHeap.add(num);
                break;
            }
                
            num -= 1;
            maxHeap.add(num);
        }
        for(int num : maxHeap){
            answer += Math.pow(num, 2);
        }
        return answer;
    }
}