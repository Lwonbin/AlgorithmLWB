import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();  // StringBuilder 사용
        
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();
        HashMap<Integer, Integer> mapXY = new HashMap<>();
        
        // X 문자열의 각 숫자 빈도 계산
        for(int i = 0; i < X.length(); i++) {
            int chX = X.charAt(i) - '0';  // Integer.parseInt(X.charAt(i)+"") 대신
            mapX.put(chX, mapX.getOrDefault(chX, 0) + 1);
        }
        
        // Y 문자열의 각 숫자 빈도 계산
        for(int i = 0; i < Y.length(); i++) {
            int chY = Y.charAt(i) - '0';  // Integer.parseInt(Y.charAt(i)+"") 대신
            mapY.put(chY, mapY.getOrDefault(chY, 0) + 1);
        }
        
        // 공통으로 존재하는 숫자의 최소 개수를 mapXY에 저장
        for (int i = 0; i <= 9; i++) {
            if (mapX.containsKey(i) && mapY.containsKey(i)) {
                int min = Math.min(mapX.get(i), mapY.get(i));
                if (min > 0) {
                    mapXY.put(i, min);
                }
            }
        }

        // 공통 숫자가 없으면 -1 반환
        if (mapXY.size() == 0) {
            return "-1";
        }

        // 큰 숫자부터 리스트에 추가
        for (int i = 9; i >= 0; i--) {
            if (mapXY.containsKey(i)) {
                for (int j = 0; j < mapXY.get(i); j++) {
                    answer.append(i);  // StringBuilder에 숫자 추가
                }
            }
        }

        // 결과가 0으로만 이루어졌다면 0 하나만 반환
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}
