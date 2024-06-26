import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty() || stack.peek() == s.charAt(i)){
                stack.add(s.charAt(i));
            }else if(stack.peek() != s.charAt(i)){
                stack.pop();
            }
            
            if(stack.isEmpty() || (!stack.isEmpty() && i==s.length()-1)){
                answer++;
            }
        }
        
        return answer;
    }
}