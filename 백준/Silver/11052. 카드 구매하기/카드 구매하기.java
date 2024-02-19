import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] d = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                d[i] = Math.max(d[i],d[i-j]+arr[j]);
            }
        }
        bw.write(d[N]+"");


        br.close();
        bw.flush();
        bw.close();

    }
}
