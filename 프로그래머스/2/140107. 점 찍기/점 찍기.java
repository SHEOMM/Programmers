import java.util.*;
import java.lang.Math;

class Solution {
    public long solution(int k, int d) {
        if(k>d){
            return 1;
        }
        long answer = 0;
        for(int i = 0; i<=d; i+=k){
            long dSquare = (long)d*d;
            long iSquare = (long)i*i;
            double max = Math.sqrt(dSquare - iSquare);
            long maxNum = (long)Math.floor(max);
            answer += maxNum/k + 1;
            
        }
 
        return answer;
    }
}