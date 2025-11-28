import java.util.*;

class Solution {
    
    static class Graph{
        int to;
        int weight;
        
        public Graph(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Graph>[] list = new ArrayList[N+1];
        
        for(int i=1; i<=N ;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            
            list[a].add(new Graph(b,w));
            list[b].add(new Graph(a,w));
        }
        
        PriorityQueue<Graph> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        
        int[] dist = new int[N+1];
        Arrays.fill(dist ,Integer.MAX_VALUE);
        dist[1] = 0;
        
        pq.add(new Graph(1,0));
        
        while(!pq.isEmpty()){
            Graph cur = pq.poll();
            int curNode = cur.to;
            int curW = cur.weight;
            
            if(curW > dist[curNode]) continue;
            
            for(Graph nextNode : list[curNode]){
                int nextVillage = nextNode.to;
                int nextWeight = curW + nextNode.weight;
                
                if(nextWeight < dist[nextVillage]){
                    dist[nextVillage] = nextWeight;
                    pq.add(new Graph(nextVillage, nextWeight));
                }
                
            }
        }
        
        
        for(int i=1; i<=N; i++){
            if(dist[i] != -1 && dist[i] <= K){
                answer++;
            }
        }
        
        
        return answer;
    }
    

}