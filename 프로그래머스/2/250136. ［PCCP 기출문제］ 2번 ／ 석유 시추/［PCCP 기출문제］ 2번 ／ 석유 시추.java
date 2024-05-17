import java.util.*;

class Solution {
    private final int[] moveX = {1, -1, 0, 0};
    private final int[] moveY = {0, 0, 1, -1};
    private final int directionCount = 4;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for(int k = 0; k<land[0].length; k++){
            sizeMap.put(k, 0);
        }
        int[][] visited = new int[land.length][land[0].length];
        
        for(int i = 0; i<land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                if(land[i][j] == 1 && visited[i][j] == 0){

                    Queue<Point> queuePoint = new LinkedList<>();
                    Set<Integer> xArea = new HashSet<>();
                    int areaSize = 0;
                    
                    queuePoint.offer(new Point(i, j));
                    visited[i][j] = 1;
                    
                    while(!queuePoint.isEmpty()){
                        Point point = queuePoint.poll();
                        xArea.add(point.x);
                        areaSize++;
                        checkDirection(queuePoint, point, land, visited);
                    }
                    for(Integer x: xArea){
                        sizeMap.put(x, sizeMap.get(x) + areaSize);
                    }
                    
                }
            }
        }
        
        for(Integer key: sizeMap.keySet()){
            if(sizeMap.get(key) > answer)
                answer = sizeMap.get(key);
        }
        return answer;
    }
    
    private void checkDirection(Queue<Point> queue, Point point, int[][] land, int[][] visited){
        for(int i = 0; i<directionCount; i++){
            int x = point.x + moveX[i];
            int y = point.y + moveY[i];
            if(validatePosition(x, y, land.length, land[0].length)){
                if(land[y][x] == 1 && visited[y][x] == 0){
                    queue.offer(new Point(y, x));
                    visited[y][x] = 1;
                }
            }
        }
    }
    
    private boolean validatePosition(int x, int y, int n, int m){
        return !(x < 0 || x > m-1 || y < 0 || y > n-1);
    }
}

class Point{
    public int x;
    public int y;
    
    public Point(int y, int x){
        this.x = x;
        this.y = y;
    }
}

class Area{
    public int size;
    public Set<Integer> xArea;
    
    public Area(int size, Set<Integer> xArea){
        this.size = size;
        this.xArea = xArea;
    }
    
    public int checkArea(int x){
        if(xArea.contains(x)){
            return size;
        }
        return 0;
    }
}