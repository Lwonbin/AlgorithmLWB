import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        int answer = 0;
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            
            list[from].add(to);
            list[to].add(from);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        
        int max = Integer.MIN_VALUE;
        
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : list[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] +1;
                    queue.add(next);
                    max = dist[next];
                }
                
            }
        }
        
        for(int i=1; i<n+1; i++){
            if(dist[i] == max){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}