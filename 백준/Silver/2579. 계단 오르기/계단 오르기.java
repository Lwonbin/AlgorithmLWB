import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];

        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            int cur = Integer.parseInt(br.readLine());
            score[i] = cur;
        }

        if(N==1){
            System.out.println(score[1]);
            return;
        }else if(N==2){
            System.out.println(score[1]+score[2]);
            return;
        }



        dp[1] = score[1];
        dp[2] = score[2] + score[1];
        dp[3] = Math.max(score[1]+score[3], score[2]+score[3]);

        for(int i=4; i<N+1; i++){
            dp[i] = Math.max(dp[i-2]+score[i], dp[i-3]+score[i-1]+score[i]);
        }


        System.out.println(dp[N]);





        br.close();
        bw.flush();
        bw.close();

    }
}
