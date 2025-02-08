import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        long total = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            total += arr[i][1]; 
        }

       
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        long curSum = 0;
        for (int i = 0; i < N; i++) {
            curSum += arr[i][1];
            if (curSum >= (total + 1) / 2) { 
                System.out.println(arr[i][0]); 
                break;
            }
        }
    }
}
