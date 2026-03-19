    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = 1;

            int sum = arr[0];

            int min = Integer.MAX_VALUE;

            if(sum >= M){
                System.out.println(1);
                return;
            }

            while(start <= end){
                if(end == N){
                    break;
                }


                if(sum + arr[end] < M){
                    sum += arr[end];
                    end++;
                }else{
                    min = Math.min(min, end-start+1);
                    sum -= arr[start];
                    start++;
                }
            }

            if(min == Integer.MAX_VALUE){
                System.out.println(0);
            }else{
                System.out.println(min);
            }







        }

    }