    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int N,M;
        static int[] arr;

        static boolean[] visited;

        static int[] num;

        static StringBuilder sb;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());

            num = new int[N];
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);



            arr = new int[M];
            visited = new boolean[N];
            dfs(0, 0);


            System.out.println(sb.toString());

        }


        static void dfs(int depth, int start){
            if(depth == M){
                for(int i=0; i<M; i++){
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }

            int prev = -1;


            for(int i=start; i<N; i++){
                if(visited[i]) continue;
                if(prev == num[i]) continue;

                visited[i] = true;
                arr[depth] = num[i];
                prev = num[i];
                dfs(depth +1, i+1);
                visited[i] = false;
            }




        }



    }