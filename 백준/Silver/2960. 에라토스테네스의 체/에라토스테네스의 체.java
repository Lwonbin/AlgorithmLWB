    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N+1];

            for(int i=2; i<=N; i++){
                arr[i] = i;
            }

            int idx = 0;

            for(int i=2; i<=N; i++){
                if(arr[i] == 0) continue;

                for(int j=i; j<=N; j+=i){
                    if(arr[j] != 0){
                        arr[j] = 0;
                        idx++;
                    }
                    if(idx == K){
                        System.out.println(j);
                        return;
                    }

                }
            }





        }

    }