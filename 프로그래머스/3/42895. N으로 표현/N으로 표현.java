import java.util.*;
import java.lang.Math;


class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        if(N == number)
            return 1;
        
        List<Set<Integer>> DP = new ArrayList<>();
        Set<Integer> list = new HashSet<>(); 
        DP.add(list);
        Set<Integer> list2 = new HashSet<>();
        list2.add(N);
        DP.add(list2);
    
        
        for(int i=2; i<=8; i++){
            Set<Integer> list3 = new HashSet<>();
            
            for(int j=1; j<i; j++){
                int k = i-j;
                for(Integer num1: DP.get(j)){
                    for(Integer num2: DP.get(k)){
                        list3.add(num1 + num2);
                        list3.add(num1 - num2);
                        list3.add(num1 * num2);
                        if(num2 != 0)
                            list3.add(num1 / num2);            
                    }
                }
            }
            
            int concatNum= 0;
            for(int x = 0; x<i; x++){
                concatNum += N * Math.pow(10, x);
            }
            list3.add(concatNum);
            if(list3.contains(number)){
                return i;
            }
            DP.add(list3);
            
            
        }
        
        return -1;
    }
}