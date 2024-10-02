import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Double> map2 = new HashMap<>();
        
        for(int i=0; i<stages.length; i++){
            map.put(stages[i], map.getOrDefault(stages[i],0)+1);
        }
        

        int count = stages.length;

            for (int i = 1; i <= N; i++) {
            int stageCount = map.getOrDefault(i, 0);  // 현재 스테이지에 있는 사용자 수
            if (count > 0) {
                map2.put(i, (double) stageCount / count);  // 실패율 계산
            } else {
                map2.put(i, 0.0);  // 남은 사용자가 없는 경우 실패율 0
            }
            count -= map.getOrDefault(i,0);
            }
        
        List<Integer> list = new ArrayList<>(map2.keySet());
        Collections.sort(list, (a, b) -> map2.get(b).compareTo(map2.get(a)));
        
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        

        
        return answer;
    }
}