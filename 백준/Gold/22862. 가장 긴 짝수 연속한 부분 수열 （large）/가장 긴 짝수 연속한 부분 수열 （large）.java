import java.io.*;
import java.util.*;


public class Main {
    static int[] arr;
    static int N, K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));






        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start =0;
        int end = 0;
        int result = Integer.MIN_VALUE;

        int check = 0;

        while(end < N){
            if(arr[end] % 2 != 0){
                check++;
            }

            while(check > K){
                if(arr[start] % 2 == 1) check--;
                start++;
            }



            result = Math.max(result, end - start +1 - check);
            end++;

        }

        System.out.println(result);



        br.close();

        bw.flush();
        bw.close();
    }



}
