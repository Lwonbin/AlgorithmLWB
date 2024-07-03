
import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<food.length; i++){
            if(i==0 || food[i] ==1){
                map.put(i, 0);
            }
            else if(food[i]%2==0){
                map.put(i, food[i]/2);
            }
            else{
                map.put(i, (food[i]-1)/2);
            }   
        }
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j<map.get(i); j++){
                sb.append(i);
            }
        }
        sb.append(0);
        for(int i=food.length-1; i>0; i--){
            for(int j=0; j<map.get(i); j++){
                sb.append(i);
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}