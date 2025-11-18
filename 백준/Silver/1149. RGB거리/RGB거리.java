import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        int[][] score = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = score[1][0];
        dp[1][1] = score[1][1];
        dp[1][2] = score[1][2];



        for(int i=2; i<=N; i++){
            dp[i][0] = score[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = score[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = score[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(dp[N][2],Math.min(dp[N][0],dp[N][1])));

        br.close();
        bw.flush();
        bw.close();

    }
}
