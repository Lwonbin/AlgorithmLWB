import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int target  =0;
    static Queue<int[]> queue =  new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    queue.add(new int[] {i,j});
                }
            }
        }

        bfs();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                target = Math.max(target, visited[i][j]);
            }
        }
        bw.write(target + "");




        br.close();
        bw.flush();
        bw.close();

    }

    static void bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r =  cur[0];
            int c = cur[1];


            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(graph[nx][ny] == 0 && visited[nx][ny] == 0){
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[r][c] +1;
                        graph[nx][ny] = 1;
                    }
                }
            }
        }




    }
}
