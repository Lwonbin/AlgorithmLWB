import java.io.*;
import java.util.*;

public class Main {
    static int N, M ,K;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            //가로길이
            M = Integer.parseInt(st.nextToken());
            //새로길이
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new int[N][M];

            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            count = 1;



            for(int p = 0; p<N; p++){
                for(int q = 0; q<M; q++){
                    if(map[p][q]==1 && visited[p][q] == 0){
                        bfs(q,p);
                    }
                }
            }


            int MAX = 0;
            for(int p = 0; p<N; p++){
                for(int q = 0; q<M; q++){
                    MAX = Math.max(MAX, visited[p][q]);
                }
            }

            bw.write(MAX+"\n");



        }


        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[y][x] = count;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny < N){
                    if(visited[ny][nx]== 0 && map[ny][nx] == 1){
                        queue.add(new int[]{nx, ny});
                        visited[ny][nx] = count;
                    }
                }
            }
        }

        count++;

    }
}
