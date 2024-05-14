import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[N];
        if(N>0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i =0; i<N; i++){
                arr[i] = Integer.parseInt(st2.nextToken());
            }
        }



        Arrays.sort(arr,Collections.reverseOrder());
        if(N == P && score <= arr[arr.length-1]) {
            bw.write(-1+"");
        }else{
            int rank = 1;
            for(int j=0; j<N; j++) {
                if (arr[j] > score) {
                    rank++;
                } else {
                    break;
                }

            }
            bw.write(rank+"");
        }








        br.close();
        bw.flush();
        bw.close();

    }
}
