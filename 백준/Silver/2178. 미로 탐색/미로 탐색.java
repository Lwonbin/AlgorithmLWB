import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N = 0;
    static int M = 0;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0,0);

        bw.write(map[N-1][M-1]+"");


        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if(nextX<0 || nextY<0 || nextX>=N || nextY >=M){
                    continue;
                }

                if(map[nextX][nextY]==0){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }

                queue.offer(new Point(nextX,nextY));
                visited[nextX][nextY] = true;

                map[nextX][nextY] = map[currentPoint.x][currentPoint.y]+1;
            }
        }
    }
}
