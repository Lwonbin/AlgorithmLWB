import java.io.*;
import java.util.*;

public class Main {
    static class Edge{
        int to, w;

        Edge(int to, int w){
            this.to = to;
            this. w = w;
        }

    }

    static int N,M;

    static List<Edge>[] Node;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Node = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            Node[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node[from].add(new Edge(to, weight));
            Node[to].add(new Edge(from, weight));
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int targetFrom = Integer.parseInt(st.nextToken());
            int targetTo = Integer.parseInt(st.nextToken());

            int result = bfs(targetFrom, targetTo);

            bw.write(result+"\n");

        }



        br.close();
        bw.flush();
        bw.close();

    }

    static int bfs(int targetFrom, int targetTo){

        Queue<int[]>queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        visited[targetFrom] = true;
        queue.add(new int[]{targetFrom, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curFrom = cur[0];
            int curW = cur[1];

            if(curFrom == targetTo) return curW;

            for(Edge e : Node[curFrom]){
                if(!visited[e.to]){
                    visited[curFrom] = true;
                    queue.add(new int[]{e.to, curW + e.w});
                }
            }

        }

        return -1;

    }
}
