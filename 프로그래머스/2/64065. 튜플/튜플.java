import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        String[] sap = s.split("},");
        
        
        for(int i=0; i<sap.length; i++){
            sap[i] = sap[i].replaceAll("[\\{,\\}]", " ").trim();
        }
        

        
        for(int i=0; i<sap.length; i++){
            String[] cur = sap[i].split(" ");
            for(int j=0; j<cur.length;j++){
                map.put(cur[j], map.getOrDefault(cur[j],0)+1);
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (v1,v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        //answer = new int[list.length];
        
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        
        
        
        
        
        return answer;
    }
}