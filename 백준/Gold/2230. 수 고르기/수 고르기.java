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

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());

            }

            Arrays.sort(arr);


            int start = 0;
            int end = 1;

            int min = Integer.MAX_VALUE;

            while(start <= end){

                if(end >= N){
                    break;
                }
                int cur = arr[end] - arr[start];

                if(cur < M){
                    end++;
                }else{
                    min = Math.min(min, cur);
                    start++;
                }
            }

            System.out.println(min);


        }

    }