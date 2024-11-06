import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = convertToBase(n, k);
        String[] numarr = num.split("0");
        
        System.out.println(num);
        
        for(String str : numarr){
            if(!str.isBlank() && check(Long.parseLong(str))){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean check(Long checkNum){
        if(checkNum == 1){
            return false;
        }
        
        for(int i=2; i<=(int)Math.sqrt(checkNum); i++){
            if(checkNum%i == 0){
                return false;
            }
        }
        return true;
        
    }
    
    public String convertToBase(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        if(n<k){
            sb.append(n);    
        }
        
        while(n>=k){
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        
        return sb.reverse().toString();
    }
}