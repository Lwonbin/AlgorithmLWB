import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int max = 0;

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
            if(max<arr[i]){
                max = arr[i];
            }
        }


        int left = 0;
        int right = max;


        while(left<=right){
            long sum = 0;
            int mid = (left+right)/2;

            for(int i=0; i<N; i++){
                if(arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }

            if(sum >= M){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        bw.write(right+"");


        br.close();
        bw.flush();
        bw.close();

    }
}
