import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] ans;
    public static boolean[] visit;
    public static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        ans = new int[n];

        result = 0;
        visit = new boolean[n];


        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        bw.write(result+"");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int cnt) {
        if(cnt == n){
            int sum =0;
            for(int i=0; i<n-1; i++){
                sum += Math.abs(ans[i]-ans[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for(int i=0; i<n; i++) {
            if (!visit[i]) {
                ans[cnt] = arr[i];
                visit[i] = true;
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }
}
