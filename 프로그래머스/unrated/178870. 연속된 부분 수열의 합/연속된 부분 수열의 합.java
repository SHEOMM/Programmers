import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int size = sequence.length;
        int left = 0;
        int right = size;
        int sum = 0;
        for(int L= 0, R = 0; L<size; L++){
            while(R<size && sum < k){
                sum += sequence[R++];
            }
            if(sum == k){
                int range = R - L - 1;
                if((right - left) > range){
                    left = L;
                    right = R - 1;
                }
            }
            sum -= sequence[L];
            
        }
        answer[0] = left;
        answer[1] = right;
        
        return answer;
    }

}