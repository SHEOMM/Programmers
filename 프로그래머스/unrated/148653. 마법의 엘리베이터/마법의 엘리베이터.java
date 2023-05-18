class Solution {
    public int solution(int storey) {
        int answer = 0;
        int a = 10;

        while(storey > 0){
            int b = storey % a;
            storey /= a;
            if(b>5){
                answer += 10 - b;
                storey += 1;
            }else if(b < 5){
                answer += b;
            }else{
                answer += 5;
                int next = storey % 10;
                storey += (next >= 5) ? 1 : 0;
            }
            
        }

        return answer;
    }
}