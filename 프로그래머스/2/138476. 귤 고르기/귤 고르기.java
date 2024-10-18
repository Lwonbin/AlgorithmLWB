import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(tangerine);
        
        for(int i=0; i<tangerine.length; i++){
            int gull = tangerine[i];
            map.put(gull, map.getOrDefault(gull, 0)+1);
        }
        
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i=0; i<list.size(); i++){
            k -= list.get(i);
            answer++;
            
            if(k<=0){
                break;
            }
        }
        
        return answer;
    }
}