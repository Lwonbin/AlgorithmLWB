import java.io.*;
import java.util.*;

public class Main {


    static int N,M;
    static int[][] map;
    static boolean[][] visited;


    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int tomato = Integer.parseInt(st.nextToken());
                map[i][j] = tomato;
                if(tomato == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }


        bfs();


        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(max-1);






        br.close();
        bw.flush();
        bw.close();

    }

    static void bfs(){

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i =0; i<4; i++){
                int nx = curX +dx[i];
                int ny = curY + dy[i];

                if(nx>=0&& ny>=0 && nx<N && ny<M){
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        map[nx][ny] = map[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
