import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;

    static int N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int last = 0;
        int time = 0;

        while(true){
            int result = bfs(0,0);

            if(result == 0){
                break;
            }
            last = result;
            time++;

        }

        System.out.println(time);
        System.out.println(last);



        br.close();

    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[][] newCheck = new boolean[N][M];
        newCheck[x][y] = true;

        int count = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(!newCheck[nx][ny] && map[nx][ny] == 1){
                        newCheck[nx][ny] = true;
                        map[nx][ny] = 0;
                        count++;
                    }else if(!newCheck[nx][ny] && map[nx][ny]==0){
                        newCheck[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

        return count;

    }
}
