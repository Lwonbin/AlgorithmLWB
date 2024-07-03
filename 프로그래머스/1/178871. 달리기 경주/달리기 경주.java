import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
       // 플레이어들의 이름과 인덱스를 저장하는 HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        
        for(int i=0; i< callings.length; i++){
            int index = map.get(callings[i]); //3이겠지? kai의 index는 3임
            
            String str = players[index-1]; 
            players[index-1] = callings[i];
            players[index] = str;
            map.put(callings[i], index-1);
            map.put(str, map.get(str)+1);
            
        }
        
       
        // 결과 배열 반환
        return players;
    }
}