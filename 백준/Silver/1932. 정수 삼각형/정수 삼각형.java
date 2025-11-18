import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());


        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(N==1){
            System.out.println(arr[0][0]);
            return;
        }else if(N==2){
            System.out.println(Math.max(arr[0][0]+arr[1][0], arr[0][0]+arr[1][1]));
            return;
        }

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[0][0] + arr[1][0];
        dp[1][1] = arr[0][0] + arr[1][1];

        

        for(int i=2; i<N; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }


        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(dp[N-1][i]);
        }

        list.sort(Comparator.reverseOrder());

        System.out.println(list.get(0));

        br.close();
        bw.flush();
        bw.close();

    }
}
