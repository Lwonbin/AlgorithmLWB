import java.io.*;
import java.util.*;

//2024.11.06 05:41 카더가든 얼굴 비하 김채현 인성논란 레전드..
public class Main {
    static int N = 0;
    static boolean[][] visited;
    static int[][] map;

    static ArrayList<Integer> list;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int cnt = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];
        cnt = 1;
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) -'0';
            }
        }

        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size()+"\n");
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }



        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny]==1){
                cnt++;
                dfs(nx,ny);
            }
        }
    }
}
