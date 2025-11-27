import java.util.*;

class Solution {
    
    static class Graph{
        int to;
        int weight;
        
        Graph(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<Graph>[] list = new ArrayList[N+1];
        
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            
            Graph graph1 = new Graph(a, w);
            Graph graph2 = new Graph(b, w);
            
            list[a].add(graph2);
            list[b].add(graph1);
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Graph> pq = new PriorityQueue<>(
                (o1, o2) -> o1.weight - o2.weight);
        
        pq.add(new Graph(1,0));
        
        while(!pq.isEmpty()){
            Graph cur = pq.poll();
            int to = cur.to;
            int w = cur.weight;
            
            if(w > dist[to]) continue;
            
            for(Graph next : list[to]){
                int nextVillage = next.to;
                int nextValue = w + next.weight;
                
                if(nextValue < dist[nextVillage]){
                    dist[nextVillage] = nextValue;
                    pq.add(new Graph(nextVillage, nextValue));
                    
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    

}