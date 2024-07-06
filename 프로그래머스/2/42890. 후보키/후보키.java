import java.util.*;

class Solution {
    private List<Set<Integer>> keys = new LinkedList<>();
    private List<List<Integer>> combination = new LinkedList<>();
    
    
    
    public int solution(String[][] relation) {
        int answer = 0;
        getComb(relation[0].length);
        
        for(List<Integer> comb: combination){
            if(isCandidate(comb, relation)){
                
                Set<Integer> newKey = new HashSet<>();
                for(Integer num: comb){
                    newKey.add(num);
                }
                keys.add(newKey);
            }
        }
        return keys.size();
    }
    
    private void getComb(int length){
        int[] arr = new int[length];
        for(int i = 1; i<= length; i++){
            arr[i-1] = i;
        }
        
        for(int i = 1; i<= length; i++){
            boolean[] visited = new boolean[length];
            DFS(arr, visited, 0, 0, i);
        }
        
    }
    
    private void DFS(int[] arr, boolean[] visited, int start, int depth, int length){
        if(depth == length){
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<arr.length; i++){
                if(visited[i]) 
                    list.add(arr[i]);
            }
            combination.add(list);
        
        }
        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(arr, visited, i+1, depth+1, length);
                visited[i] = false;
            }
        }
    }
    
    private boolean isCandidate(List<Integer> comb, String[][] relation){
        if(!isMinimal(comb))
            return false;
        
        int length = relation.length;
        Set<String> duplicateChecker = new HashSet<>();
        for(String[] row: relation){
            duplicateChecker.add(getTempKey(comb, row));
        }
        
        if(length == duplicateChecker.size())
            return true;
        
        return false;
    }
    
    private String getTempKey(List<Integer> comb, String[] row){
        String key = "";
        for(Integer index: comb){
            key = key + "-" + row[index - 1];
        }
        return key;
    }
    
    private boolean isMinimal(List<Integer> comb){
        for(Set<Integer> key: keys){
            if(comb.containsAll(key))
                return false;
        }
        return true;
    }
    
    
}