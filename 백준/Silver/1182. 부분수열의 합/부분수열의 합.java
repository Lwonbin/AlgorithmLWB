import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static int S = 0;
    static int[] arr;

    static int result =0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(0,0);

        if( S == 0){
            result--;
        }

        bw.write(result+"");




        br.close();
        bw.flush();
        bw.close();

    }

    public static void dfs(int depth, int sum){
        if(depth == N){
            if(sum == S){
                result ++;
            }
            return;
        }

        dfs(depth +1, sum + arr[depth]);
        dfs(depth +1, sum);
    }
}
