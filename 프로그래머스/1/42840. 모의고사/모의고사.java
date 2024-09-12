import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] correct = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == student1[i%5]){
                correct[0]++;
            }
            if(answers[i] == student2[i%8]){
                correct[1]++;
            }
            if(answers[i] == student3[i%10]){
                correct[2]++;
            }
        }
        
        int max = Math.max(correct[0],Math.max(correct[1], correct[2]));
        
        
        List<Integer> list = new ArrayList<>();
        for(int j=0; j<3; j++){
            if(max == correct[j]){
                list.add(j+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }
        
    
        
        return answer;
    }
}