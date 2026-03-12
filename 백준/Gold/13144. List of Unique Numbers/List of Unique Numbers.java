    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            int N = Integer.parseInt(br.readLine());


            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] check = new boolean[1000001];


            int start = 0;
            int end = 0;

            long answer = 0;
            while(start < N){
                while(end < N && !check[arr[end]]){
                    check[arr[end]] = true;
                    end++;
                }

                answer += end-start;

                check[arr[start]] = false;
                start++;

            }

            System.out.println(answer);








        }

    }