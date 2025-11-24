import java.io.*;
import java.util.*;
public class Main {
    static int K;
    static int N;

    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        result = bfs(N);

        bw.write(result+"");



        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        dist[node] = 0;


        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == K){
                return dist[cur];
            }

            if(cur+1>=0 && cur+1 <=100000){
                if(!visited[cur+1]){
                    queue.add(cur+1);
                    visited[cur+1] = true;
                    dist[cur+1] = dist[cur]+1;
                }

            }

            if(cur-1 >=0 && cur-1 <=100000){
                if(!visited[cur-1]) {
                    queue.add(cur - 1);
                    visited[cur-1] = true;
                    dist[cur - 1] = dist[cur] + 1;
                }
            }

            if(cur * 2 >=0 && cur*2 <=100000){
                if(!visited[cur*2]){
                    queue.add(cur*2);
                    visited[cur*2] = true;
                    dist[cur*2] = dist[cur] + 1;
                }
            }


        }

        return -1;


    }
}
