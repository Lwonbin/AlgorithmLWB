import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        int[] arr = new int[N];



        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);


        while(start <= end){
            if(end > N-1){
                break;
            }

            if(arr[end] - arr[start] >= M){
                min = Math.min(min, arr[end]-arr[start]);
                start++;
            }else if(arr[end] - arr[start] < M){
                end++;

            }

        }






        System.out.println(min);






        br.close();
        bw.flush();
        bw.close();
    }
}
