import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<cards1.length; i++){
            queue1.add(cards1[i]);
        }
        
        for(int i=0; i<cards2.length; i++){
            queue2.add(cards2[i]);
        }
        Boolean check = true;


        for(int i=0; i<goal.length; i++){
            if(!queue1.isEmpty() && queue1.peek().equals(goal[i])){
                queue1.poll();
            }else if(!queue2.isEmpty() && queue2.peek().equals(goal[i])){
                queue2.poll();
            }else{
                check = false;
                break;
            }
            
        }        
        
        if(!check){
            answer = "No";
        }else{
            answer = "Yes";
        }
        
        return answer;
    }
}