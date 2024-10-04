class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] dart = new int[3];
        
        String numstr = "";
        int idx = 0;
        int num = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            
            
            if(ch>='0' && ch<='9'){
                numstr += String.valueOf(ch);
 
                
            }
            else if(ch =='S' || ch == 'D' || ch == 'T'){
                num = Integer.parseInt(numstr);
                if(ch == 'S'){
                    dart[idx++] = (int)Math.pow(num,1);
                }else if(ch == 'D'){
                    dart[idx++] = (int)Math.pow(num,2);
                }else{
                    dart[idx++] = (int)Math.pow(num,3);
                }
                numstr="";
                    
            }else{
                if(ch == '*'){
                    dart[idx-1] *= 2;
                    if(idx-2>=0) dart[idx-2] *=2;
                }
                else{
                    dart[idx-1] *= -1;
                }
            }
            
            
            answer = dart[0] + dart[1] + dart[2];
            
            
        }
        
        return answer;
    }
}