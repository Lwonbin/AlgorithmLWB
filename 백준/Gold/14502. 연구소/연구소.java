import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                int target = Integer.parseInt(st.nextToken());
                map[i][j] = target;
            }
        }


        dfs(0);

        System.out.println(max);



        br.close();
    }

    static void dfs(int wallcnt){
        if(wallcnt == 3){
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallcnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }


    static void bfs(){
        int[][] copymap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copymap[i] = map[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copymap[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }



        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(copymap[ny][nx] == 0){
                        copymap[ny][nx] = 2;
                        queue.add(new int[]{ny,nx});
                    }
                }
            }

        }

        int count = 0;


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copymap[i][j]==0){
                    count++;
                }
            }
        }

        max = Math.max(count, max);


    }
}
