import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static int[] nx = {-1, 0, 1, 0};
    static int[] ny = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];



        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='L'){
                    visited = new boolean[N][M];
                    int val = bfs(i,j);
                    result = Math.max(val, result);
                }
            }
        }

        bw.write(result+"");



        br.close();
        bw.flush();
        bw.close();
    }
    public static int bfs(int i, int j){
        Queue<Po> queue = new LinkedList<>();
        int val = 0;
        visited[i][j] = true;
        queue.add(new Po(i,j,0));

        while(!queue.isEmpty()){
            Po p = queue.poll();
            for(int k=0; k<4; k++){
                int newX = p.x + nx[k];
                int newY = p.y + ny[k];

                if(newX >=0 && newX<N && newY>=0 && newY<M && !visited[newX][newY] && map[newX][newY]=='L'){
                    visited[newX][newY] = true;
                    queue.add(new Po(newX, newY, p.cnt+1));
                    val = Math.max(val, p.cnt+1);
                }

            }
        }

        return val;

    }


    public static class Po{
        int x;
        int y;
        int cnt;
        public Po(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}

