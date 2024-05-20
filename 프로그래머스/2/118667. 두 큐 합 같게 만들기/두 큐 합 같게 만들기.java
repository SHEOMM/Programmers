import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> realQueue1 = new LinkedList<>();
        Queue<Integer> realQueue2 = new LinkedList<>();
        for(int i = 0; i<queue1.length; i++){
            sum1 += queue1[i];
            realQueue1.add(queue1[i]);
            realQueue2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        long totalSum = sum1 + sum2;
        long target = totalSum/2;
        if(totalSum%2 != 0){
            return -1;
        }
        for(int i = 0; i<(queue1.length+queue2.length) * 2; i++){
            // System.out.println("num1: " + sum1 + " num2: " + sum2);
            if(sum1 > sum2){
                int num = realQueue1.poll();
                sum1 -= num;
                sum2 += num;
                realQueue2.add(num);
                answer++;
            }else if(sum1 < sum2){
                int num = realQueue2.poll();
                sum2 -= num;
                sum1 += num;
                realQueue1.add(num);
                answer++;
            }else if(sum1 == sum2){
                break;
            }
        }
        if(sum1 != sum2)
            return -1;
        
        return answer;
    }
}