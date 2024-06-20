import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = 0;

        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max<arr[i]){
                max = arr[i];
            }
        }


        long left = 0;
        long right = max+1;

        while(left < right){
            long count =0;
            long mid = (left + right)/2;

            for(int i=0; i<K; i++){
                count += arr[i]/mid;
            }

            if(count >= N){
                left = mid+1;
            }else{
                right = mid;
            }
        }


        bw.write((left-1)+"");


        br.close();
        bw.flush();
        bw.close();


    }
}
