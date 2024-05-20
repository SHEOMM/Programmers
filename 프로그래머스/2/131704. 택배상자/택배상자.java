import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int[] indexOrder = new int[order.length];
        for(int i = 0; i < order.length; i++){
            indexOrder[order[i] - 1] = i;
            
        }
        
        int curIndex = 0;
        int curOrder = 0;
        Stack<Integer> subContainer = new Stack<>();
        while(true){
            if(curIndex >= indexOrder.length){
                if(curOrder >= indexOrder.length)
                    break;
                if(subContainer.isEmpty() ||
                   (!subContainer.isEmpty() && curOrder != subContainer.peek())){
                    break;
                }
            }
            if(curIndex < indexOrder.length && indexOrder[curIndex] == curOrder){
                curIndex++;
                curOrder++;
                answer++;
            }else if(!subContainer.isEmpty() && curOrder == subContainer.peek()){
                subContainer.pop();
                curOrder++;
                answer++;
            }else {
                subContainer.push(indexOrder[curIndex]);
                curIndex++;
            }
        }
        
        return answer;
    }
}