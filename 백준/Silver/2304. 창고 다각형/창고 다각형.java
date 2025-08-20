import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        int max = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            max = Math.max(max, y);
            arr[i][0] = x;
            arr[i][1] = y;
        }


        Arrays.sort(arr, Comparator.comparingInt(r -> r[0]));


        int start = 0;
        int end = N-1;


        while(arr[start][1] != max) start++;
        while(arr[end][1] != max) end--;


        int curX = arr[0][0];
        int curY = arr[0][1];

        int answer =0;
        for(int i=1; i<=start; i++){
            if(curY <= arr[i][1]){
                answer += (arr[i][0] - curX) * curY;
                curX = arr[i][0];
                curY = arr[i][1];
            }
        }



        curX = arr[N-1][0];
        curY = arr[N-1][1];

        for(int i = N-2; i>=end; i--){
            if(curY <= arr[i][1]){
                answer += (curX - arr[i][0]) * curY;
                curX = arr[i][0];
                curY = arr[i][1];
            }
        }


        answer += (arr[end][0] - arr[start][0] +1) * max;


        System.out.println(answer);

        br.close();


    }
}
