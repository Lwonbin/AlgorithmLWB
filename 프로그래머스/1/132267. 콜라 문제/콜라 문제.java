class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int percent = 0;
        while(n>=a){
            
            if(n%a == 0){
                answer += n/a*b;
                n/=a;
                n*=b;
            }else{
                percent = n%a;
                answer += n/a*b;
                
                n/= a;
                n *= b;
                n += percent;
            }
            
        }
            
        
        
        
        
        return answer;
    }
}