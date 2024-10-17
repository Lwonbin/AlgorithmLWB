import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int last = people.length-1;
        
        while(start <= last){
            if(people[start]+people[last] <= limit){
                start++;
            }
            last--;
            
            answer++;
        }
        
        return answer;
    }
}