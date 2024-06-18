import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }

        for(int j=0; j<M; j++){
            dp[0][j][0] = arr[0][j];
            dp[0][j][1] = arr[0][j];
            dp[0][j][2] = arr[0][j];
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                if(j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                } else if(j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                }
            }
        }

        int min = (int)1e9;

        for(int p=0; p<M; p++){
            for(int q=0; q<3; q++){
                min = Math.min(min, dp[N-1][p][q]);
            }
        }

        System.out.println(min);






        br.close();
        bw.flush();
        bw.close();

    }
}
