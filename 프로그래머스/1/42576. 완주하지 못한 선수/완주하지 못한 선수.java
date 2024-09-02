import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // participant 배열로 map 구성
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // completion 배열로 map 갱신
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 값이 0이 아닌 키를 반환
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}
