import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] dist;
    static int N,M;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(dist[N-1][M-1]);

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x,y});
        dist[x][y] = 0;

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int curX = cur[0];
            int curY = cur[1];

            if(curX == N-1 && curY == M-1){
                break;
            }

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    int w = map[nx][ny];

                    if(dist[nx][ny] > dist[curX][curY] +w){
                        dist[nx][ny] = dist[curX][curY] +w;

                        if(w==0){
                            dq.addFirst(new int[]{nx,ny});
                        }else{
                            dq.addLast(new int[]{nx,ny});
                        }
                    }
                }
            }



        }

    }


}