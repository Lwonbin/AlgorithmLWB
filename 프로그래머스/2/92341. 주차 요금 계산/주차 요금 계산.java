import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, String> map = new HashMap<>(); // 입차 시간을 기록하는 맵
        HashMap<String, Integer> countTime = new HashMap<>(); // 누적 주차 시간을 기록하는 맵
        
        for (int i = 0; i < records.length; i++) {
            String carNum = records[i].substring(6, 10); // 차량 번호
            String time = records[i].substring(0, 5); // 시간 정보
            
            // 입차 기록 처리
            if (records[i].length() == 13) {
                map.put(carNum, time);
            }
            // 출차 기록 처리
            else if (records[i].length() == 14 && map.containsKey(carNum)) {
                int outTimeHour = Integer.parseInt(time.substring(0, 2));
                int outTimeMinute = Integer.parseInt(time.substring(3, 5)); 
                String inTime = map.get(carNum);
                int inTimeHour = Integer.parseInt(inTime.substring(0, 2));
                int inTimeMinute = Integer.parseInt(inTime.substring(3, 5));
                
                // 주차 시간 계산 (출차 시간 - 입차 시간)
                int parkingTime = (outTimeHour - inTimeHour) * 60 + (outTimeMinute - inTimeMinute);
                
                // 누적 주차 시간 업데이트
                countTime.put(carNum, countTime.getOrDefault(carNum, 0) + parkingTime);
                
                // 입차 기록 제거
                map.remove(carNum);
            }
        }
        
        // 출차 기록이 없는 차량에 대해 23:59에 출차 처리
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String carNum = entry.getKey();
            String inTime = entry.getValue();
            int inTimeHour = Integer.parseInt(inTime.substring(0, 2));
            int inTimeMinute = Integer.parseInt(inTime.substring(3, 5));
            
            // 23:59에서 입차 시간을 빼서 주차 시간 계산
            int parkingTime = (23 - inTimeHour) * 60 + (59 - inTimeMinute);
            
            // 누적 주차 시간 업데이트
            countTime.put(carNum, countTime.getOrDefault(carNum, 0) + parkingTime);
        }
        
        // 차량 번호를 오름차순으로 정렬한 후 요금 계산
        List<String> sortedCarNums = new ArrayList<>(countTime.keySet());
        Collections.sort(sortedCarNums);
        
        int[] answer = new int[sortedCarNums.size()];
        int j = 0;
        
        for (String carNum : sortedCarNums) {
            int totalTime = countTime.get(carNum);
            if (totalTime <= fees[0]) {
                answer[j] = fees[1];
            } else {
                answer[j] = fees[1] + (int)Math.ceil((totalTime - fees[0]) / (double)fees[2]) * fees[3];
            }
            j++;
        }
        
        return answer;
    }
}
