import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[] ranking = new int[n+1];
        
        List<Integer>[] win = new ArrayList[n+1];
        List<Integer>[] lose = new ArrayList[n+1];
        
        for(int i =0; i<n+1; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for(int i=0; i<results.length; i++){
            int u = results[i][0];
            int v = results[i][1];
            
            win[u].add(v);
            lose[v].add(u);
        }
        
        
        for(int i=1; i<n+1; i++){
            boolean[] visited = new boolean[n+1];
            int wins = bfs(i, win, visited);
            int loses = bfs(i, lose, visited);
            
            if(wins + loses == n-1){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
    
    
    static int bfs(int start, List<Integer>[] graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : graph[cur]){
                if(!visited[next]){
                    count++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        return count;
        
    }
}