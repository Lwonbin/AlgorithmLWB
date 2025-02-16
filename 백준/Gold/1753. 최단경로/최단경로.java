import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException { // static 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = -1;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }

            if (nodeIdx == -1) break;

            visited[nodeIdx] = true;

            for (Node adjNode : graph.get(nodeIdx)) { // 인접 노드 갱신
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
