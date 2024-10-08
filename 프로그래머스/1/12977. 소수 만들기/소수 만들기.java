class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(isPrime(sum)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public boolean isPrime(int sum){
        boolean check = true;
        for(int i=2; i<sum; i++){
            if(sum%i == 0){
                check = false;
            }
        }
        return check;
        
    }
}