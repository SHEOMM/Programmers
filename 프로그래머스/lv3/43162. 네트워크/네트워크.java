import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                Queue<Integer> que = new LinkedList<>();
                que.add(i);
                while(!que.isEmpty()){
                    int num = que.poll();
                    for(int j = 0; j<n; j++){
                        int connect = computers[num][j];
                        if(visited[j] != 1 && connect == 1){
                            visited[j] = 1;
                            que.add(j);
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}