class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] dic = new int[e+1];
        int[] cnt = new int[e+1];
        dic[1] = 1;
        cnt[1] = 1;
        for(int i=2;i<=e;i++){
            int n = e/i;
            int j = i;
            for(int k=1;k<=n;k++){
                dic[j] += 1;
                j += i;
            }   
        }
        
        // e부터 1까지 각각 최대 출연 번호 저장
        int v = 0;
        for(int i=e;i>=1;i--){
            if(dic[i] >= v){
                v = dic[i];
                cnt[i] = i;
            } else{
                cnt[i] = cnt[i+1];
            }
        }
        
        for(int i=0;i<starts.length;i++){
            answer[i] = cnt[starts[i]];
        }
        return answer;
    }
}