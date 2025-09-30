import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }


        int count = bfs(1,0);

        System.out.println(count);




        br.close();

    }

    static int bfs(int cur, int count){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cur, count});
        visited[cur] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            int[] friend = queue.poll();
            int curI = friend[0];
            int curCount = friend[1];

            if(curCount >= 2){
                continue;
            }

            for(int next: graph[curI]){
                if(!visited[next]){
                    visited[next] = true;
                    cnt++;
                    queue.add(new int[]{next, curCount+1});
                }
            }
        }

        return cnt;

    }
}
