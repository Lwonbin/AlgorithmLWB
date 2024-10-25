import java.util.*;
class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer =0;
        

        
        
        for(int i=0; i<skill_trees.length; i++){
            Stack<Character> stack = new Stack<>();
        
            for(int x=skill.length()-1; x>=0; x--){
                stack.push(skill.charAt(x));
            }
            boolean check = false;
            char[] arr = skill_trees[i].toCharArray();
            
            for(int j=0; j<arr.length; j++){
                if(skill.indexOf(arr[j])!=-1){
                    if(!stack.isEmpty() && stack.peek()==arr[j]){
                        stack.pop();
                    }else if((!stack.isEmpty() && stack.peek()!=arr[j])){
                        check = true;
                    }
                }
            }
            
            
            if(!check){
                answer++;
            }
                
                   
                   
                 
            
        }
                   
                   
        
        
        return answer;
    }
}