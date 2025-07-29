import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            int A = Integer.parseInt(br.readLine());
            arr[i] = A;
        }

        int cur = 0;
        int dir = N-1;

        int count = 0;
        while(cur != K){
            if(cur + arr[dir] > K){
                dir--;
            }else if(cur + arr[dir] <= K){
                cur += arr[dir];
                count++;
            }

        }


        System.out.println(count);




        br.close();
        bw.flush();
        bw.close();
    }
}
