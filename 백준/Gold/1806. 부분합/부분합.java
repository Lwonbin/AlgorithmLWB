import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min = Integer.MAX_VALUE;


        int start = 0;
        int end = 0;
        int sum = 0;


        while (true) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            } else if (end == N || start == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }


        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min);
        }


//        sum += 1;
//        sum += 1;
//        sum += 1;
//        sum += 1;
//
//        start = 0, end = 4;
//
//        sum += 10; end == 5


        br.close();
        bw.flush();
        bw.close();

    }
}
