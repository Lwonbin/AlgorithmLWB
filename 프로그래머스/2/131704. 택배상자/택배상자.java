import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        int cur = 1;
        
        while(count< order.length){
            int target = order[count++];
            if(cur<=target){
                while(cur!=target){
                    stack.push(cur++);
                }
                cur++;
                answer++;
            }
            
            else{
                if(stack.isEmpty() || stack.peek() != target) break;
                else{
                    answer++;
                    stack.pop();
                }
            }
        }
        return answer;
    }
}