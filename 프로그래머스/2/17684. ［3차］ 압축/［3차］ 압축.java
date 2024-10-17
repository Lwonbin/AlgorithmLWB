import java.util.*;
class Solution {
    public int[] solution(String msg) {
        String[] init = {"", "A", "B","C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y","Z"};
        
        List<String> dic = new ArrayList<>(Arrays.asList(init));
                
        ArrayList<Integer> list = new ArrayList<>();
        int s=0;
        int n = msg.length();
        
        
        while(s<n){
            StringBuilder currentWord = new StringBuilder();
            currentWord.append(msg.charAt(s));
                      
            while (s + 1 < n && dic.contains(currentWord.toString() + msg.charAt(s + 1))) {
                s++;
                currentWord.append(msg.charAt(s));
            }
            
            list.add(dic.indexOf(currentWord.toString()));
            
            if(s+1<n){
                dic.add(currentWord.toString()+msg.charAt(s+1));
            }
            
            s++;
            
            
            
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        

        return answer;
    }
}