import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];


        for(int i=0; i<N; i++){
            int w = Integer.parseInt(br.readLine());
            arr[i] = w;
        }

        Arrays.sort(arr,Collections.reverseOrder());


        int maxWeight = 0;

        for(int i=0; i<N; i++){
            maxWeight = Math.max(maxWeight, arr[i] * (i+1));
        }

        System.out.println(maxWeight);

        br.close();
        bw.flush();
        bw.close();

    }
}
