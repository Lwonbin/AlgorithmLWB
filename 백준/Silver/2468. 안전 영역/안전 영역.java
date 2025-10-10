import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int maxResult = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }


        for(int i=0; i<maxHeight; i++){
            boolean[][] checkMap = countMap(i);
            boolean[][] visited = new boolean[N][N];
            int safeCheck = 0;
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(!checkMap[j][k] && !visited[j][k]){
                        bfs(j,k, visited, checkMap);
                        safeCheck++;
                    }
                }
            }
            maxResult = Math.max(safeCheck, maxResult);
        }

        System.out.println(maxResult);



        br.close();

    }



    static boolean[][] countMap(int i){
        boolean[][] checkMap = new boolean[N][N];

        for(int p=0; p<N; p++){
            for(int j=0; j<N; j++){
                if(map[p][j] <= i){
                    checkMap[p][j] = true;
                }
            }
        }

        return checkMap;
    }


    static void bfs(int j, int k, boolean[][] visited, boolean[][] checkMap){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{j,k});
        visited[j][k] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >=0 && ny>=0 && nx<N && ny<N){
                    if(!visited[nx][ny] && !checkMap[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
