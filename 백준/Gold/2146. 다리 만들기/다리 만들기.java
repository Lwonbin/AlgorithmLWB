import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[][] map;
    static int[][] dist;

    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 2;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    bfsSET(i,j,count);
                    count++;
                }
            }
        }


        int answer = Integer.MAX_VALUE;
        for(int island = 2; island<count; island++){
            int bridge = bfsCHECK(island);
            answer = Math.min(answer, bridge);
        }

        bw.write(answer+"");








        br.close();
        bw.flush();
        bw.close();
    }

    static int bfsCHECK(int island){
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], -1);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==island){
                    queue.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }




        int minBridge = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (map[nx][ny] != island && map[nx][ny] != 0) {
                    return dist[curX][curY];
                }

                if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[curX][curY] + 1;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
        return minBridge;

    }


    static void bfsSET(int x, int y, int count){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        map[x][y] = count;
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    if(!visited[nx][ny] && map[nx][ny] != 0){
                        map[nx][ny] = count;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
