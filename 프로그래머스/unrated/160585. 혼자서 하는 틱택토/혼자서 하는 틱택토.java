class Solution {
    public int solution(String[] board) {    
        int Ocnt = 0;
        int Xcnt = 0;
        
        for(int i =0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[i].charAt(j) == 'O')
                    Ocnt++;
                if(board[i].charAt(j) == 'X')
                    Xcnt++;
            }
        }

        if(Ocnt - Xcnt > 1 || Ocnt - Xcnt < 0)
            return 0;
        
        if(isWin(board, 'O') && isWin(board, 'X'))
            return 0;
        if(isWin(board,'O')){
            if(Ocnt - Xcnt != 1)
                return 0;
        }
        if(isWin(board, 'X')){
            if(Ocnt - Xcnt != 0)
                return 0;
        }
        return 1;
    }
    

    public boolean isWin(String[] board, char s){
        if(isRow(board, s) || isColumn(board, s) || isDiagonal(board, s)){
            return true;
        }
        return false;
    }

    public boolean isRow(String[] board, char s){
        for(int i = 0; i<board.length; i++){
            int cnt = 0;
            while(true){
                if(cnt == 3){
                    return true;
                }
                if(board[i].charAt(cnt) == s){
                    cnt++;
                }else{
                    break;
                }
            }
        }
        return false;
    }
    public boolean isColumn(String[] board, char s){
        for(int i = 0; i<board.length; i++){
            if(board[0].charAt(i) == s){
                if(board[1].charAt(i) == s && board[2].charAt(i) == s){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isDiagonal(String[] board, char s){

        if(board[0].charAt(0) == s){
            if(board[1].charAt(1) == s && board[2].charAt(2) == s){
                return true;
            }
        }
        
        if(board[0].charAt(2) == s && board[1].charAt(1) == s
          && board[2].charAt(0) == s)
            return true;
        return false;
    }
    
}