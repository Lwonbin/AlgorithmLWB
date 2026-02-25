    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int T = Integer.parseInt(br.readLine());

            StringBuilder sb= new StringBuilder();
            for(int i=0; i<T; i++){
                int N = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] arr = new int[N];
                for(int j=0; j<N; j++){
                    arr[j] = Integer.parseInt(st.nextToken());
                }

                long sum = 0;

                int max= Integer.MIN_VALUE;
                for(int j=N-1; j>=0; j--){
                    if(max <= arr[j]){
                        max = arr[j];
                    }else{
                        sum += max-arr[j];
                    }
                }

                sb.append(sum).append("\n");


            }

            System.out.println(sb.toString());

        }

    }