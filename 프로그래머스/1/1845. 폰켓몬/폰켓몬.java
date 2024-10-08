import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length/2;
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        if(map.size() > n){
            answer = n;
        }
        else{
            answer = map.size();
        }
        
        
        
        return answer;
    }
}