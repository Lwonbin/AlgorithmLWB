import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<prices.length; i++){
            queue.add(prices[i]);
        }
        
         for(int i = 0; i < prices.length; i++) {
            int count = 0;
            int price = queue.poll();
            
            // 현재 가격 이후의 가격들을 비교
            for(int j = i + 1; j < prices.length; j++) {
                count++;
                if(price > prices[j]) { 
                    break;
                }
            }
            
            answer[i] = count;
        }
        
        
        return answer;
    }
}