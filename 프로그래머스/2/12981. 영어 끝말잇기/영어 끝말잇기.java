import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];
        
        String str = words[0];
        set.add(str);
        
        
        for(int i=1; i<words.length; i++){
            
                      
            int z = i;
            String cur = words[i];
            if(set.contains(cur)){
                z++;
                while(z>n){
                    z-=n;
                }
                answer[0] = z; 
                
                answer[1] = (int) Math.ceil((double)(i+1)/n);
                break;
            }
            
            set.add(cur);
            
  
            if(str.charAt(str.length()-1) != cur.charAt(0)){
                System.out.println(z);
                z++;
                while(z>n){
                    z-=n;
                }
                answer[0] = z; 
                
                answer[1] = (int) Math.ceil((double)(i+1)/n);
                break;
            }
            str = cur;
            
        }
        
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");

        return answer;
    }
}