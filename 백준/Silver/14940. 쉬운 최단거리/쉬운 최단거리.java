import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;

    static int[][] result;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};





    static int n = 0;
    static int m = 0;
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        result = new int[n][m];

        int x =0, y=0;

        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j]==2){
                    x = i;
                    y = j;
                }else if(map[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        bfs(x,y);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    result[i][j] = -1;
                }
                bw.write(result[i][j] +" ");
            }
            bw.write("\n");
        }






        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int tmp[] = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        visited[nx][ny] = true;
                        result[nx][ny] = result[tmp[0]][tmp[1]] +1;

                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
