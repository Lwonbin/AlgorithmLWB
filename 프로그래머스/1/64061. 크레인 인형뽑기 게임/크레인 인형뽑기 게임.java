import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int[] count = new int[board[0].length];
        
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i< board[0].length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i] !=0){
                    count[i] = j;
                    break;
                    
                }
            }

        }
        
        
        for(int i=0; i<moves.length; i++){
            if(count[moves[i]-1] > board.length-1){
                continue;
            }
            int current = board[count[moves[i]-1]][moves[i]-1];
            
            if(!stack.isEmpty() && stack.peek() == current){
                stack.pop();
                answer += 2;
            }else{
                stack.push(current);
                
            }
            
            count[moves[i]-1]++;
        }
        
        return answer ;
    }
    
    
    
}