import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(int i=0; i<skip.length(); i++){
            list.add(skip.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            int count = 0;
            
            char ch = s.charAt(i);
            
            while(count < index){
                ch++;
                
                if(ch > 'z'){
                ch-=26;
                }
                
                if(!list.contains(ch)){
                    count++;
                }
                
                
            }
        sb.append(ch);
            
        }
        answer = sb.toString();
        
        
        return answer;
    }
}