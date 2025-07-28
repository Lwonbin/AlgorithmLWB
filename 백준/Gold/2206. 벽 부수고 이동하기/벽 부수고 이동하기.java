import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int result = 0;

    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[2][N][M];


        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }


        int result = bfs(0,0);

        if(N==1 && M==1){
            System.out.println(1);
            return;
        }


        if(result == -1){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }


        br.close();

    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,1,0});
        visited[0][y][x] = true;


        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];
            int breakCheck = cur[3];


            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];


                if(nx >=0 && ny >=0 && ny<N && nx<M){
                    if(nx == M-1 && ny == N-1){
                        return dist +1;
                    }

                    if(!visited[breakCheck][ny][nx] && map[ny][nx] == '0'){
                        queue.add(new int[]{nx,ny, dist+1,breakCheck});
                        visited[breakCheck][ny][nx] = true;
                    }

                    if(!visited[1][ny][nx] && map[ny][nx] == '1' && breakCheck == 0){
                        queue.add(new int[]{nx,ny,dist+1,1});
                        visited[1][ny][nx] = true;
                    }
                }
            }
        }

        return -1;
    }
}
