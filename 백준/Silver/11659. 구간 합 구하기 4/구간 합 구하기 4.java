    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            int[] prefix = new int[N];

            int[] arr = new int[N];



            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            prefix[0] = arr[0];
            for(int i=1; i<N; i++){
                prefix[i] = prefix[i-1] + arr[i];
            }




            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) -1;
                int b = Integer.parseInt(st.nextToken()) -1;

                int sum = 0;
                if(a == 0){
                    sum = prefix[b];
                }else{
                    sum = prefix[b] - prefix[a-1];
                }

                System.out.println(sum);

            }


        }
    }