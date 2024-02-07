import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i  =0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        Arrays.sort(arr);

        for(int j =0; j<N; j++){
            bw.write(arr[j]+"\n");
        }


        br.close();
        bw.flush();
        bw.close();

    }
}
