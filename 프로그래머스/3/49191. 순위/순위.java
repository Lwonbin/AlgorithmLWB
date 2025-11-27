import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<Integer>[] win = new ArrayList[n+1];
        List<Integer>[] lose = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for(int i =0; i<results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            
            win[a].add(b);
            lose[b].add(a);
        }
        
        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            int winCNT = bfs(i, visited, win);
            int loseCNT = bfs(i, visited, lose);
            
            if(winCNT + loseCNT == n-1){
                answer++;
            }
        }
        
        return answer;
    }
    
    static int bfs(int i, boolean[] visited, List<Integer>[] list){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : list[cur]){
                if(!visited[next]){
                    count++;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        
        return count;
    }
}