class Solution {
    
    private int count(int size, int w){
        int result = size/(2*w + 1);
        if(size%(2*w + 1) != 0)
            result++;
        return result;
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;
        for(int num: stations){
            if(begin < num - w)
                answer += count((num - w) - begin, w);
            begin = num + w + 1;
        }
        if(stations[stations.length-1] + w < n){
            answer += count(n - (stations[stations.length-1] + w), w);
        }

        return answer;
    }
}