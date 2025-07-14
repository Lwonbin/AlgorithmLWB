import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);
        int result = 0;

        for(int i=0; i<N; i++){
            int target = arr[i];
            int start = 0;
            int end = N-1;

            while(start < end ){



                if(arr[start] + arr[end] == target) {
                    if(start == i){
                        start++;
                    }else if(end == i){
                        end--;
                    }else {
                        result++;
                        break;
                    }

                }else if(arr[start] + arr[end] < target){
                    start++;
                }else if(arr[start] + arr[end] > target){
                    end--;
                }
            }


        }


        System.out.println(result);




        br.close();
        bw.flush();
        bw.close();

    }
}
