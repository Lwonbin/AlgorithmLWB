import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] newarray = new int[commands[i][1]-commands[i][0]+1];
            
            List<Integer> list = new ArrayList<>();
            
            for(int j = commands[i][0]-1; j<=commands[i][1]-1; j++){
                list.add(array[j]);
            }
            for(int p=0; p<list.size(); p++){
                newarray[p] = list.get(p);
            }
            
            Arrays.sort(newarray);
            
            answer[i] = newarray[commands[i][2]-1];
            
            
            
        }
        
        return answer;
    }
}