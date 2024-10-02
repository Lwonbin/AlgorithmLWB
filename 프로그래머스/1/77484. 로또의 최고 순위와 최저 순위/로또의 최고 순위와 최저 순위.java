import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCount = 0;
        int correctCount =0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                zeroCount++;
            }else{
                list.add(lottos[i]);  
            }
        }
        
        for(int i=0; i<win_nums.length; i++){
            if(list.contains(win_nums[i])){
                correctCount++;
            }
        }
        
        
        if(correctCount+ zeroCount == 6) answer[0] = 1;
        else if(correctCount + zeroCount ==5) answer[0] = 2;
        else if(correctCount + zeroCount==4) answer[0] = 3;
        else if(correctCount + zeroCount==3) answer[0] = 4;
        else if(correctCount + zeroCount==2) answer[0] = 5;
        else answer[0] = 6;
        
        
        if(correctCount == 6) answer[1] = 1;
        else if(correctCount ==5) answer[1] = 2;
        else if(correctCount ==4) answer[1] = 3;
        else if(correctCount ==3) answer[1] = 4;
        else if(correctCount ==2) answer[1] = 5;
        else answer[1] = 6;
        

        
        
        
        
        return answer;
    }
}