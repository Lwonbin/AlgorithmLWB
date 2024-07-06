class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String target_color = board[h][w];
        
        //동
        if(w+1 < board[0].length && board[h][w+1].equals(target_color)){
            answer++;
        }
        //서
        if(w-1 >=0 && board[h][w-1].equals(target_color)){
            answer++;
        }
        //북
        if(h+1 < board.length && board[h+1][w].equals(target_color)){
            answer++;
        }
        if(h-1 >=0 && board[h-1][w].equals(target_color)){
            answer++;
        }
        
        return answer;
    }
}