import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<bridge_length-1; i++){
            queue.add(0);
        }
        
        int current_w = truck_weights[0];
        queue.add(current_w);
        
        
        int index = 1;
        answer ++;
        
        while(!queue.isEmpty()){
            answer++;
            
            int remove = queue.poll();
            
            current_w -= remove;
            
            if(index < truck_weights.length){
                if(current_w + truck_weights[index] <= weight){
                    current_w += truck_weights[index];
                    queue.add(truck_weights[index]);
                    index++;
                }else{
                    queue.add(0);
                }
                
            }
            
        }
        
        
        
        
        
        
        
        return answer;
    }
}