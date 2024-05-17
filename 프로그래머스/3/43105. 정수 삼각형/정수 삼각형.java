class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] DP = new int[size][triangle[size-1].length];
        for(int i = 1; i<triangle.length; i++){
            for(int j =0; j<triangle[i].length; j++){
                int raw = triangle[i][j];
                if(validate(i-1, j-1, triangle[i-1].length)){
                    triangle[i][j] += triangle[i-1][j-1]; 
                }
                if(validate(i-1, j, triangle[i-1].length)){
                    if(triangle[i][j] < triangle[i-1][j] + raw){
                        triangle[i][j] = triangle[i-1][j] + raw;
                    }
                }
            }
        }
        int answer = 0;
        int lastRow = triangle.length-1;
        for(int i = 0; i<triangle[lastRow].length; i++){
            if(triangle[lastRow][i] > answer){
                answer = triangle[lastRow][i];
            }
        }
        return answer;
    }
    
    public boolean validate(int i, int j, int length){
        return !(i<0 || i >= length || j<0 || j>=length);
    }
}