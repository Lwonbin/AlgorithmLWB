import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] jihun;
    static int[][] fire;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] WJ = new int[2];
    static int[] WF = new int[2];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        jihun = new int[R][C];
        fire = new int[R][C];


        Queue<int[]> fireQueue = new LinkedList<>();
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'J'){
                    WJ[0] = i;
                    WJ[1] = j;
                }else if(str.charAt(j) == 'F'){
                    fire[i][j] = 1;
                    fireQueue.add(new int[] {i,j});

                }
            }
        }

        fireBfs(fireQueue);
        jihunBfs(WJ[0], WJ[1]);


    }

    static void fireBfs(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                    if(fire[nx][ny]==0 && map[nx][ny] == '.'){
                        fire[nx][ny] = fire[curX][curY] + 1;
                        queue.add(new int[] {nx,ny});

                    }
                }
            }


        }
    }

    static void jihunBfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        jihun[x][y] = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                    if(jihun[nx][ny]==0 && map[nx][ny] == '.'){
                        int nextTime = jihun[curX][curY] + 1;
                        if(fire[nx][ny] == 0 || nextTime < fire[nx][ny]){
                            jihun[nx][ny] = nextTime;
                            queue.add(new int[] {nx,ny});
                        }else{
                            jihun[nx][ny] = 0;
                        }
                    }
                }

            }

            if(curX == 0 || curY == 0 || curX == R-1 || curY == C-1){
                System.out.println(jihun[curX][curY]);
                System.exit(0);
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
