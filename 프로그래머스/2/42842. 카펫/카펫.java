class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int i=3;
        while(true){
            int w = (brown - (2*i))/2+2;
            
            if(i*w==brown+yellow){
                if((w-2) * (i-2) == yellow){
                    answer[0] = w;
                    answer[1] = i;
                    break;
                }
            }
            i++;
        }
        
        
        return answer;
    }
}