    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] line = new int[N];

            for(int i=0; i<N; i++){
                line[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N+1];


            int max = 0;
            for(int i=0; i<N; i++){
                int cur = line[i];
                dp[cur] = dp[cur-1] +1;

                max= Math.max(max, dp[cur]);
            }


    
            System.out.println(N-max);










        }

    }