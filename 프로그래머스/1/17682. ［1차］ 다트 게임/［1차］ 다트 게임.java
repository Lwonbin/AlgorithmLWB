class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        
        int[] score = new int[3];
        
        String[] strArr = dartResult.split("D|S|T");
        
        for(int i=0; i<3; i++){
            String cur = strArr[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<cur.length(); j++){
                if(cur.charAt(j)!='*' && cur.charAt(j)!='#'){
                    sb.append(cur.charAt(j));
                }
            }
            score[i] = Integer.parseInt(sb.toString());
        }
        
        
        
        
        
        int idx = 0;
        for(int i=0; i<dartResult.length(); i++){
            int sum = 0;
            if(dartResult.charAt(i) == 'S'){
                idx++;
                
            }else if(dartResult.charAt(i) == 'D'){
                score[idx] *= score[idx];
                idx++;
            
            }else if(dartResult.charAt(i) == 'T'){
                score[idx] *= score[idx] * score[idx];
                idx++;
                
            }else if(dartResult.charAt(i) == '*'){
                if(idx == 1){
                    score[0] = score[0] * 2;
                }else{
                    for(int j=idx-2; j<idx; j++){
                        score[j] = score[j]*2;
                    }
                }
            }else if(dartResult.charAt(i) == '#'){
                score[idx-1] *= -1;
            }
            

            
        }
             for(int i=0; i<3; i++){
                answer += score[i];
            }
        
        return answer;
    }
}