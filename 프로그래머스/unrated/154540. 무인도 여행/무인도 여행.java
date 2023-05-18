import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        LinkedList<Integer> answerList = new LinkedList<>();
        
        
        int N = maps.length;
        int M = maps[0].length();
        
        int[][] visited = new int[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j =0; j<M; j++){
                char a = maps[i].charAt(j);
                if(a != 'X' && visited[i][j] == 0){
                    visited[i][j] = 1;
                    answerList.add(dfs(maps, visited, N, M, i, j));
                }
            }
        }
        System.out.println(answerList);
        if(answerList.size() == 0){
            int[] fail = new int[1];
            fail[0] = -1;
            return  fail;
        }
        
        Collections.sort(answerList);
        return answerList.stream().mapToInt(i->i).toArray();
    }
    
    public int dfs(String[] maps, int[][] visited, int N, int M, int i, int j){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 0;
        Stack<LinkedList<Integer>> dfsStack = new Stack<>();
        LinkedList<Integer> firstList = new LinkedList<>();
        firstList.add(i);
        firstList.add(j);
        dfsStack.push(firstList);
        
        while(dfsStack.size() != 0){
            LinkedList<Integer> list = dfsStack.pop();
            int a = list.get(0);
            int b = list.get(1);
            cnt += Character.getNumericValue(maps[a].charAt(b));
            for(int k = 0; k<dx.length; k++){
                int c = a + dy[k];
                int d = b + dx[k];
                if(c >= 0 && c < N && d >= 0 && d < M){
                    if(maps[c].charAt(d) != 'X' && visited[c][d] == 0){
                        visited[c][d] = 1;
                        LinkedList<Integer> list2 = new LinkedList<>();
                        list2.add(c);
                        list2.add(d);
                        dfsStack.push(list2);
                    }
                }
            }
        }
        return cnt;
    }
    
}