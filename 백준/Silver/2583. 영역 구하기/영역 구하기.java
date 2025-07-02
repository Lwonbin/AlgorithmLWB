import java.io.*;
import java.util.*;
public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static  int[] dx = {-1, 1, 0, 0};
    static  int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i=0;i<K; i++){
            st = new StringTokenizer(br.readLine());
            int LX = Integer.parseInt(st.nextToken());
            int LY = Integer.parseInt(st.nextToken());
            int RX = Integer.parseInt(st.nextToken());
            int RY = Integer.parseInt(st.nextToken());

            for(int j=LX;j<RX;j++){
                for(int k=LY;k<RY;k++){
                    map[j][k] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    int area = bfs(i, j);
                    areas.add(area);
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for(int a : areas) System.out.print(a + " ");


        br.close();
        bw.flush();
        bw.close();
    }

    static public int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int area = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                int nx = cur [0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx,ny});
                        area++;
                    }
                }
            }
        }
        return area;

    }
}
