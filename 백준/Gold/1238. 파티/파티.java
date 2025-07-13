import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int to;
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M, X;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        List<Node>[] graph = new ArrayList[N + 1];
        List<Node>[] reverseGraph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }


        for(int i = 0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st2.nextToken());
            int to = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            graph[from].add(new Node(to, cost));

            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }


        int[] toX = dijkstra(reverseGraph, X); // i → X (역방향 그래프 이용)
        int[] fromX = dijkstra(graph, X);      // X → i (정방향 그래프 이용)

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int roundTrip = toX[i] + fromX[i];
            if (roundTrip > max) max = roundTrip;
        }

        System.out.println(max);




        br.close();
        bw.flush();
        bw.close();

    }

    static int[] dijkstra(List<Node>[] graph, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                int newCost = dist[cur.to] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }

        return dist;
    }

}
