import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        
        
        for(int i=0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;
        
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : graph[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] +1;
                    queue.add(next);
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<n+1; i++){
            max = Math.max(dist[i], max);
            System.out.print(dist[i]+" ");
        }
        
        for(int i=0; i<n+1; i++){
            if(max == dist[i]){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}