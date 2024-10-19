import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<want.length; i++){
            list.add(want[i]);
        }
        
        for(int i=0; i<discount.length-9; i++){
            
            boolean isMatch = false;
            
            int[] NumCopy = Arrays.copyOf(number, number.length);
            
            for(int j=i; j<i+10; j++){
                int idx = list.indexOf(discount[j]);
                
                if(idx == -1){
                    continue;
                }
                
                NumCopy[idx]--;
                
            }
            
            for(int z=0; z<NumCopy.length; z++){
                if(NumCopy[z]!=0){
                    isMatch = true;
                    break;
                }
            }
            
            if(!isMatch){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}