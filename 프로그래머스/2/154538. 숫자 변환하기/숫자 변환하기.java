import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        
        return bfs(x,y,n);
    }
    
    
    
    
    public int bfs(int x, int y, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,0});
        
        boolean[] visited = new boolean[y+1];
        
        while(!q.isEmpty()){
            int[] tmparr = q.poll();
            int curNum = tmparr[0];
            int count = tmparr[1];
            
            if(curNum == y){
                return count;
            }
            
            
            if(curNum+n <= y && !visited[curNum+n]){
                q.add(new int[]{curNum+n, count+1});
                visited[curNum+n] = true;
            }
            
             if(curNum*2 <= y && !visited[curNum*2]){
                q.add(new int[]{curNum*2, count+1});
                visited[curNum*2] = true;
            }
            
             if(curNum*3 <= y && !visited[curNum*3]){
                q.add(new int[]{curNum*3, count+1});
                visited[curNum*3] = true;
            }
        }
        
        return -1;
    }
}