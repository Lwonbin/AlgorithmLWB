    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                int level = Integer.parseInt(br.readLine());
                arr[i] = level;
            }
            int idx = N-2;
            int cur = arr[N-1];
            int cnt = 0;
            while(idx >= 0){

                while(cur<=arr[idx]){
                    arr[idx]--;
                    cnt++;
                }

                cur = arr[idx];
                idx--;
            }

            System.out.println(cnt);

        }

    }