class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_width = 0;
        int max_length = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                max_width = Math.max(sizes[i][1],max_width);
                max_length = Math.max(sizes[i][0],max_length);
            }else{
                max_width = Math.max(sizes[i][0], max_width);
                max_length = Math.max(sizes[i][1],max_length);
            }
        }
        
        answer = max_width*max_length;
        
        return answer;
    }
}