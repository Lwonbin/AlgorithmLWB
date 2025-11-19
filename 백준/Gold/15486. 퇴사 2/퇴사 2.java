import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        dp[N] = 0;

        for(int i=N-1; i>=0; i--){
            if(i+T[i] <= N){
                dp[i] = Math.max(P[i]+ dp[i+T[i]], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[0]);



        br.close();
    }
}
