import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }


        int count = 0;
        for(int i=0; i<N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }

        System.out.println(count);




    }



    static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i=0; i<N; i++){
                if(graph[cur][i] ==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
