import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek()<K){
            
 
            int notspicy1 = pq.poll();
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            int notspicy2 = pq.poll();
            
            int newspicy = notspicy1 + (notspicy2*2);
            pq.add(newspicy);
            answer++;
            
            
        }
        return answer;
    }
}