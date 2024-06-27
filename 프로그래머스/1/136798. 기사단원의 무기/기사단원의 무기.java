class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number];
        for(int i=1; i<=number; i++){
            int DT = 0;
            for(int j=1; j<= Math.sqrt(i); j++){
                if(i % j ==0){
                    DT++;
                    if(j*j != i){
                        DT++;
                    }
                }
                if(DT>limit){
                    break;
                }
            }
            arr[i-1] = DT;
            
        }
        
  
        for(int p=0; p<arr.length; p++){
            if(arr[p] > limit ){
                answer += power;
            }else{
                answer += arr[p];
            }
        }
        
        return answer;
    }
}