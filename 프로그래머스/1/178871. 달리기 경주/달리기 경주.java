import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
       // 플레이어들의 이름과 인덱스를 저장하는 HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // 초기화: 플레이어 이름과 인덱스 매핑
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        // 호출 목록을 처리
        for (String calling : callings) {
            // 호출된 선수의 인덱스
            int currentIndex = map.get(calling);
            
            // 만약 첫 번째 선수가 아니라면 위치를 바꿈
            if (currentIndex > 0) {
                // 배열에서 호출된 선수를 한 칸 앞으로 이동
                String temp = players[currentIndex];
                players[currentIndex] = players[currentIndex - 1];
                players[currentIndex - 1] = temp;
                
                // HashMap에서 위치 업데이트
                map.put(players[currentIndex], currentIndex);
                map.put(players[currentIndex - 1], currentIndex - 1);
            }
        }
        
        // 결과 배열 반환
        return players;
    }
}