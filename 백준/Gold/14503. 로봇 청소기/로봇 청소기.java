import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        visited = new boolean[N][M];




        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                int state = Integer.parseInt(st.nextToken());
                if(state == 0){
                    count++;
                }
                map[i][j] = state;

            }
        }

        int count = bfs(r,c,d);
        System.out.println(count);

        br.close();

    }


    static int bfs(int r, int c, int d){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c,d});

        int result = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curWay = cur[2];

            if(map[curX][curY] == 0){
                result++;
                visited[curX][curY] = true;
                map[curX][curY] = -1;
            }

            boolean check = false;
            int tempDir = curWay;
            for(int i=0; i<4; i++){
                tempDir = (tempDir + 3) % 4; // 반시계 회전
                int nx = curX + dx[tempDir];
                int ny = curY + dy[tempDir];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(map[nx][ny] == 0 && !visited[nx][ny]){
                        check = true;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny,tempDir});
                        break;

                    }
                }
            }

            if (!check) {
                int backDir = (curWay + 2) % 4;
                int bx = curX + dx[backDir];
                int by = curY + dy[backDir];

                if (bx < 0 || by < 0 || bx >= N || by >= M || map[bx][by] == 1) {
                    break; // 뒤가 벽이면 종료
                } else {
                    queue.add(new int[]{bx, by, curWay}); // 방향 유지한 채 후진
                }
            }
        }

        return result;
    }
}
