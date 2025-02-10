import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {

    static int dx[] = { 1,0,-1,0 };
    static int dy[] = { 0,1,0,-1 };
    static char[][] color;
    static boolean[][] visit;

    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        color = new char[N][N];
        visit = new boolean[N][N];


        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                color[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        bw.write(cnt+"");


        visit = new boolean[N+1][N+1];
        cnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(color[i][j] == 'G'){
                    color[i][j] = 'R';
                }
            }
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        bw.write(" "+cnt);




        bw.flush();
        bw.close();
        br.close();


    }


    static void dfs(int x, int y) {

        visit[x][y] = true;
        char TempColor = color[x][y];

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= N || newX < 0 || newY >=N || newY <0){
                continue;
            }


             if(!visit[newX][newY] && color[newX][newY] == TempColor){
                 dfs(newX, newY);
             }
        }




    }


}