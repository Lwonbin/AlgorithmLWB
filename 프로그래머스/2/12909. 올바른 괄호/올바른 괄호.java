import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        
        for(char a : s.toCharArray()){
            stack.push(a);
        }
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c == ')'){
                stack2.push(c);
            }
            else{
                if(stack2.isEmpty()){
                    answer = false;
                }else{
                    stack2.pop();
                }
            }
            if(stack.isEmpty() && !stack2.isEmpty()){
                answer = false;
            }
            
            
            
            
        }
        
        
        
        
        
        
        return answer;
    }
}