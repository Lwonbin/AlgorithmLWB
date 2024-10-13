import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        boolean[][] check = new boolean[id_list.length][id_list.length];
        HashMap<String, Integer> map = new HashMap<>();
        int[] count = new int[id_list.length];
        
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i],i);
        }
        
        
        
        for(int i=0; i<report.length; i++){
            String[] sendReceive = report[i].split(" ");
            String send = sendReceive[0];
            String receive = sendReceive[1];
    
            if(!check[map.get(send)][map.get(receive)]){
                count[map.get(receive)]++;
                check[map.get(send)][map.get(receive)]=true;
            }
        }
        
        
        //count 에는 1202가 들어가있게 된다.
        
        for(int i=0; i<id_list.length; i++){
            int validCount = 0;
            for(int j=0; j<id_list.length; j++){
                if(check[i][j] == true && count[j]>=k){
                    validCount++;
                }
            }
            answer[i] = validCount;
        }
        
        return answer;
    }
}