import java.io.*;
import java.util.*;




public class Main {
    public static class Edge{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static int N,M;

    static int[] dist;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        visited = new boolean[N+1];


        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int i =0 ; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            //A와 B는 헛간 위치
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //C는 A와 B 사이의 소의 갯수
            int C = Integer.parseInt(st.nextToken());

            graph[B].add(new Edge(A,C));
            graph[A].add(new Edge(B,C));
        }


        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Edge(1,0));
        dist[1] = 0;


        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;

            if(visited[now]){
                continue;
            }

            visited[now] = true;

            for(Edge next : graph[now]){
                if(dist[next.to] > dist[now] + next.cost){
                    dist[next.to] = dist[now] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }


        System.out.println(dist[N]);


        br.close();
        bw.flush();
        bw.close();

    }
}
