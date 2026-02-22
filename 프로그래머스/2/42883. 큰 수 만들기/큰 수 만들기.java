import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int count =0;
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(Integer.parseInt(number.charAt(0)+""));
        
        
        
        for(int i=1; i<number.length(); i++){
            int cur = Integer.parseInt(number.charAt(i)+"");
            
            while(!stack.isEmpty() && count<k){
                if(stack.peek() < cur){
                    stack.pop();
                    count++;
                }else{
                    break;
                }
            }
            
            stack.push(cur);
        }
        
        
        while(count < k){
            stack.pop();
            count++;
        }
        
        
        int size = stack.size();
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
       
        return sb.toString();
    }
}