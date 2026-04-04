import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        HashMap<String, Integer> Tomap = new HashMap<>();
        HashMap<String, List<String>> Frommap = new HashMap<>();
        answer = new int[id_list.length];
        
        for(int i=0; i<report.length; i++){
            String[] cur = report[i].split(" ");
            String from = cur[0];
            String to = cur[1];
            
            Frommap.putIfAbsent(from, new ArrayList<>());
            
            if(!Frommap.get(from).contains(to)){
            Frommap.get(from).add(to);
            Tomap.put(to, Tomap.getOrDefault(to, 0) + 1);
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            String cur = id_list[i];
            int count = 0;
            
            List<String> target = Frommap.getOrDefault(cur, new ArrayList<>());
            
            for(String str : target){
                if(Tomap.getOrDefault(str, 0) >= k){
                    count++;
                }
            }
            answer[i] = count;
            
            
        }
        
        
        return answer;
    }
}