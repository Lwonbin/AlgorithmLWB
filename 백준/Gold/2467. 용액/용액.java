import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = arr.length-1;

        int min = Integer.MAX_VALUE;


        /*
        sum = 3임
        start = 0, end = 3인 상태

         */

        int bestStart = 0;
        int bestEnd = N-1;



        while(start < end){

            int sum = arr[start] + arr[end];
            int absSum = Math.abs(sum);

            if(absSum <= min){
                min = absSum;
                bestStart = start;
                bestEnd = end;
            }


            if(sum> 0){
                end--;
            }else{
                start++;
            }

        }



        System.out.println(arr[bestStart] +" " +arr[bestEnd]);

        br.close();
        bw.flush();
        bw.close();

    }
}
