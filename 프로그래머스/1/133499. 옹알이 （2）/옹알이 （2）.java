class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] arr = {"aya", "ye", "woo", "ma"};
        String[] arr2 = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for(int i=0; i<babbling.length; i++){
            int count =0;
            for(int j=0; j<4; j++){
                if(babbling[i].contains(arr2[j])){
                    count++;
                }
            }
            if(count>0){
                continue;
            }
            
            babbling[i] = babbling[i].replace("aya"," ");
            babbling[i] = babbling[i].replace("ye"," ");
            babbling[i] = babbling[i].replace("woo"," ");
            babbling[i] = babbling[i].replace("ma"," ");
            babbling[i] = babbling[i].replace(" ","");
            
            if(babbling[i].length()==0){
                answer++;
            }
        }
        
        
        return answer;
    }
}