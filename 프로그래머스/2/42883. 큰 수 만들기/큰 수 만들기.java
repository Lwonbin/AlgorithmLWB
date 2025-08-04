import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int count =0;
        
        int max = number.charAt(0)-'0';
        
        Stack<Integer> stack = new Stack<>();
        stack.push(number.charAt(0)-'0');
        
        for (int i = 1; i < number.length(); i++) {
            int cur = number.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < cur && count < k) {
                stack.pop();
                count++;
            }

            stack.push(cur);
        }

        if(count<k){
            for(int i=0; i<k-count; i++){
                stack.pop();
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        

        
        return sb.reverse().toString();
    }
}