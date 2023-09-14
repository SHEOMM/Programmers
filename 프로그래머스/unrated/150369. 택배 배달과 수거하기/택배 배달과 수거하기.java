import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> D = new Stack<>();
        Stack<Integer> P = new Stack<>();
        long answer = 0;
        
        for(int i=0; i<n; i++){
            D.push(deliveries[i]);
            P.push(pickups[i]);
        }
        
        //둘 중 하나라도 참이면 계속 굴러간다.
        while(!D.isEmpty() || !P.isEmpty()){
            
            //맨 끝이 0일 경우 계산할 필요 없으니 pop
            while(!D.isEmpty() && D.peek() == 0){
                D.pop();
            }
            while(!P.isEmpty() && P.peek() == 0){
                P.pop();
            }
            
            answer += 2*Math.max(D.size(), P.size());
            
            int Dtarget = 0;
            while(!D.isEmpty()){
                int Dcurrent = D.pop();
                
                if(Dtarget + Dcurrent <= cap){
                    //배달 가능
                    Dtarget += Dcurrent;
                }else{
                    //배달 불가능
                    //남은 배달 양 스택에 넣어주기
                    D.push(Dtarget + Dcurrent - cap);
                    break;
                }
            }
            
            int Ptarget = 0;
            while(!P.isEmpty()){
                int Pcurrent = P.pop();
                
                if(Ptarget + Pcurrent <= cap){
                    Ptarget += Pcurrent;
                }else{
                    P.push(Ptarget + Pcurrent - cap);
                    break;
                }
            }
        }
        
        return answer;
    }
}