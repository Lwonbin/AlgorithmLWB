import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character,Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char ch = keymap[i].charAt(j);
                
                if(map.containsKey(ch)){
                    int idx = map.get(ch);
                    map.put(ch, Math.min(idx, j+1));
                }else{
                    map.put(ch, j+1);    
                }
            }
        }
        
        
        for(int i=0; i<targets.length; i++){
            int count = 0;
            for(int j=0; j<targets[i].length(); j++){
                char current = targets[i].charAt(j);
                
                if(map.containsKey(current)){
                    answer[i] += map.get(current);
                    count++;
                }else{
                    answer[i] = -1;
                    break;
                }
            }
            
        }
        
        
        return answer;
    }
}