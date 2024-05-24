import java.util.*;
import java.lang.Math.*;

class Solution {
    
    private static final int[] xPos = {1, -1, 0, 0};
    private static final int[] yPos = {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int k = 0; k<answer.length; k++){
            answer[k] = 1;
        }
        int i = 0;
        for(String[] place: places){
            
            List<Node> startPoint = getStartPoint(place);
            Queue<Node> queue = new LinkedList<>();
            
            for(Node start: startPoint){
                queue.offer(start);
                while(!queue.isEmpty()){
                    Node node = queue.poll();
                    if(get(place, node.y, node.x) == 'P' && !node.hasPartition &&
                      !(node.x == start.x && node.y == start.y)){
                        // System.out.println("Warn!");
                        // System.out.println("i: " + i);
                        // System.out.println(get(place, node.y, node.x));
                        // System.out.println("start: " + start);
                        // System.out.println(node);
                        answer[i] = 0;
                        break;
                    }
                    else if(get(place, node.y, node.x) == 'X'){
                        node.hasPartition = true;
                    }
                    if(node.depth == 2)
                        continue;
                    
                    for(int j = 0; j<xPos.length; j++){
                        int x = node.x + xPos[j];
                        int y = node.y + yPos[j];
                        if(isValidPos(x, y)){
                            queue.offer(new Node(node.depth + 1, x, y, node.hasPartition));
                        }
                        
                    }
                    
                }
                if(answer[i] == 0)
                    break;
            }
            i++;
            
        }
        
        
        
        
        
        return answer;
    }
    
    private boolean isValidPos(int x, int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
    
    private List<Node> getStartPoint(String[] place){
        List<Node> list = new LinkedList<>();
        for(int i = 0; i<place.length; i++){
            for(int j = 0; j <place[0].length(); j++){
                if(get(place, i, j) == 'P'){
                    list.add(new Node(0, j, i, false));
                }
            }
        }
        return list;
    }
    
    private char get(String[] place, int i, int j){
        return place[i].charAt(j);
    }
    
    
}


class Node{
    public int depth;
    public int x;
    public int y;
    public boolean hasPartition;
    
    public Node(int depth, int x, int y, boolean hasPartition){
        this.depth = depth;
        this.x = x;
        this.y = y;
        this.hasPartition = hasPartition;
    }
    
    @Override
    public String toString(){
        return "x: " + x + " y: " + y + " depth : " + depth + " hasPartition: " + hasPartition;
    }
}