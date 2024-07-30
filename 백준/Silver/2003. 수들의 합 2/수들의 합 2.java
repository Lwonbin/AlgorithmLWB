import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int start = 0;
        int end = 0;

        int cnt = 0;

        int sum=0;

        for(int i = start; i<=end; i++){
            sum += arr[i];
        }

        for(int i=0;; i++){
            try{
                if(sum == M){
                  cnt++;
                  sum += arr[++end] - arr[start++];
                }else if(sum<M){
                    sum += arr[++end];
                }else{
                    sum -= arr[start];
                    start++;
                }
            } catch (Exception e){
                break;
            }

        }
        System.out.println(cnt);




        br.close();
        bw.flush();
        bw.close();

    }
}
