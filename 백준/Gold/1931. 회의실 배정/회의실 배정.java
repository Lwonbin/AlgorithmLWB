import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1]==o2[1]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });



        int result = 1;

        int end = arr[0][1];

        for(int i=1; i<N; i++){
            if(arr[i][0] >= end){
                result++;
                end = arr[i][1];
            }
        }



        System.out.println(result);






        br.close();
    }
}
