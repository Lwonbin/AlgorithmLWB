import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        
        int year = Integer.parseInt(today.substring(0,4));
        int month = Integer.parseInt(today.substring(5,7));
        int day = Integer.parseInt(today.substring(8,10));
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<privacies.length; i++){
            
            int curr_year = Integer.parseInt(privacies[i].substring(0,4));
            int curr_month = Integer.parseInt(privacies[i].substring(5,7));
            int curr_day = Integer.parseInt(privacies[i].substring(8,10));
            char realABC = privacies[i].charAt(11);
            
            for(int j=0; j<terms.length; j++){
                char ABC = terms[j].charAt(0);
                int last = Integer.parseInt(terms[j].substring(2));
                
                if(realABC == ABC){
                    curr_month += last;
                    while(curr_month > 12){
                        curr_month -=12;
                        curr_year++;
                    }
                }
            }
            
            
            if((curr_year < year) || (curr_year == year && curr_month < month) || (curr_year == year && curr_month == month && curr_day <= day)){
                list.add(i+1);
            }
    
        }
        
        answer = new int[list.size()];
        
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
    
        
        return answer;
    }
}