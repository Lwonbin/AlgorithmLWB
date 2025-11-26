class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
         
        for(int i=0; i<players.length; i++){
            if(server[i] == 0 && players[i] >= m){
                int n = players[i] / m;
                
                for(int j=0; j<k; j++){
                    if(i+j < 24){
                        server[i+j] += n;
                    }
                }
                answer += n;
                System.out.println(i);
            }else if(server[i] !=0 && players[i] >= m){
                int n = players[i] / m;
                n -= server[i];
                
                    if(n>0){
                        answer+=n;
                        System.out.println(i);
                        for(int j=0; j<k; j++){
                        if(i+j < 24){
                           server[i+j] += n;
                        }
                    }
                }
                
            }
        }
        
        // for(int i=0; i<24; i++){
        //     System.out.print(server[i]);
        // }
        
        return answer;
    }
}