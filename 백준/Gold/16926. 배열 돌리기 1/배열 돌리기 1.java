import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};


        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0; i<R; i++){

            for(int j=0; j<Math.min(N,M)/2; j++){
                int start = arr[j][j];
                int x = j;
                int y = j;
                int cnt = 0;

                while(cnt<4) {
                    int X = x +dx[cnt];
                    int Y = y +dy[cnt];

                    if(X>=j && Y>=j && X<N-j && Y<M-j ) {
                        arr[x][y] = arr[X][Y];
                        x = X;
                        y = Y;
                    }
                    else {
                        cnt++;
                    }
                }
                arr[j+1][j] = start;


            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
