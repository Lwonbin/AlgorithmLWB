import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum=0;


        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st1.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);



        for(int j=0; j<N; j++){
            sum += (arr1[j]*arr2[N-j-1]);
        }

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
