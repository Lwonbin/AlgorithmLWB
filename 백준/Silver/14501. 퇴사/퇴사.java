import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];
        int[] dp = new int[N+1];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            map[i][0] = T;
            map[i][1] = P;
        }


        dp[N] = 0;

        for(int i=N-1; i>=0; i--){
            if(i+map[i][0] <= N){
                dp[i] = Math.max(map[i][1]+dp[i+map[i][0]], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[0]);







        br.close();

    }
}
