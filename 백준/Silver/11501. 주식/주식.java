import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            long max = arr[N-1];
            for(int p=N-2; p>=0; p--){
                if(max > arr[p]){
                    sum += max-arr[p];
                }else{
                    max = arr[p];
                }
            }
            bw.write(sum+"\n");
        }


        br.close();
        bw.flush();
        bw.close();

    }
}
