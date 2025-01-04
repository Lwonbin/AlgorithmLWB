import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> visited = new HashSet<>();
        
        int x = 5;
        int y = 5;
        
        for(char ch : dirs.toCharArray()){
            
            int nx = x;
            int ny = y;
            
            
            if(ch == 'U'&& y<10) ny++;
            else if(ch == 'D'&&y>0) ny--;
            else if(ch =='L'&&x>0) nx--;
            else if(ch =='R'&&x<10) nx++;
            else continue;
            
            
            String path1 = x+""+y+""+nx+""+ny;
            String path2 = nx+""+ny+""+x+""+y;
            
            if(!visited.contains(path1) && !visited.contains(path2)){
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            
            
            x = nx;
            y = ny;
            
   
            }
      
        
        return answer;
    }
}