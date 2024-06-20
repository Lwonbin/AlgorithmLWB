import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr= new String[N];
        int[] arr2 = new int[N];



        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            arr[i] = st2.nextToken();
            arr2[i] = Integer.parseInt(st2.nextToken());

        }






        for(int j=0; j<M; j++) {
            int left= 0;
            int right = N-1;
            
            int number = Integer.parseInt(br.readLine());
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr2[mid] < number) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(arr[left]+"\n");
        }


        bw.write(sb.toString());






        br.close();
        bw.flush();
        bw.close();

    }
}
