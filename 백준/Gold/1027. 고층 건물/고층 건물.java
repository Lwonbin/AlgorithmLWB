import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }


        int result = 0;

        for(int i=0; i<N; i++) {
            int count;

                count = 0;
                double Max = Double.NEGATIVE_INFINITY;
                for (int j = i - 1; j >= 0; j--) {
                    double cur = (double) (arr[i] - arr[j]) / (i - j);
                    if (j == i-1 || cur < Max) {
                        count++;
                        Max = cur;
                    }

                }

                Max = Double.NEGATIVE_INFINITY;
                for (int k = i + 1; k < N; k++) {
                    double cur = (double) (arr[k] - arr[i]) / (k - i);

                    if (k == i+1 || cur > Max) {
                        count++;
                        Max = cur;
                    }


                }




            result = Math.max(result, count);

        }

        System.out.println(result);


        br.close();
        bw.flush();
        bw.close();


    }
}
