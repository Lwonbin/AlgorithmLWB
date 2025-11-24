import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int[][] map;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        int result = 0;


        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){

            if(map[x][y] == 0){
                map[x][y] = 2;
                result++;
            }

            boolean check = false;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if (map[nx][ny] == 0) {
                        check = true;
                    }
                }
            }


            if(!check){
                int dist = (d + 2) % 4;
                int nx = x + dx[dist];
                int ny = y + dy[dist];

                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if (map[nx][ny] == 1) {
                        break;
                    }else{
                        x = nx;
                        y = ny;
                    }
                }
            }else{

                for(int i=0; i<4; i++){
                    int dist = (d + 3) % 4;
                    int nx = x + dx[dist];
                    int ny = y + dy[dist];

                    if(nx>=0 && ny>=0 && nx<N && ny<M){
                        if(map[nx][ny] == 0){
                            x = nx;
                            y = ny;
                            d = dist;
                            break;
                        }
                    }
                    d= dist;
                }




            }

        }


        System.out.println(result);




    }
}
