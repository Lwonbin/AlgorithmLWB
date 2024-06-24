import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        
        for(int i =0; i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
    
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        for(int p=0; p<arr.length; p++){
            sb.append(arr[p]);
        }
        answer = sb.toString();
        
        return answer;
    }
}