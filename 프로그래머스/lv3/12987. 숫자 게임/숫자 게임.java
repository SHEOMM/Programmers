import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int answer = 0;
        PriorityQueue<Integer> aHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<A.length; i++){
            aHeap.add(A[i]);
            bHeap.add(B[i]);
        }
        while(!bHeap.isEmpty()){
            int b = bHeap.poll();
            while(!aHeap.isEmpty()){
                int a = aHeap.poll();
                if(b>a){
                    answer++;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}

// 8 2 4 4
// 3 3 9 9
// 8 3
// 4 3
