import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int start = 1;
        
        while(start<=elements.length){
            for(int i=0; i<elements.length; i++){
                int cur = 0;
                for(int j=i; j<i+start; j++){
                    cur +=  elements[j % elements.length];
                    
                }
                set.add(cur);
            }
            start++;
        }
        
        answer = set.size();
        
        
        return answer;
    }
}