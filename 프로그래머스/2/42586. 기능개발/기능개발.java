import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i<progresses.length; i++){
             stack.push(progresses[i]);
        }
   
        
        for(int i=stack.size()-1; i>=0; i--){
            int cnt = (int) Math.ceil((100-stack.pop())/ (double) speeds[i]);
            count.push(cnt);
        }
        
        
        while(!count.isEmpty()){
            int cnt2 = count.pop();
            int count2 = 1;
            if(count.isEmpty()){
                list.add(count2);
            }else{
                while(!count.isEmpty() && count.peek()<=cnt2){
                 count.pop();
                 count2++;
                }
                list.add(count2);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        
        return answer;
    }
}