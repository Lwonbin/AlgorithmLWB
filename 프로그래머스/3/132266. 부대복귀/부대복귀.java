import java.util.*;

class Solution {
    static List<Integer>[] list;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : list[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] +1;
                    queue.add(next);
                }
            }
        }
        
        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        
        return answer;
    }
        
}