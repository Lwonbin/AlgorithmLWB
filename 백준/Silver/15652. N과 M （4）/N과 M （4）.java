    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int N,M;
        static int[] arr;

        static boolean[] visited;

        static StringBuilder sb;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();

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


            for(int i=start; i<N; i++){
                arr[depth] = i+1;
                dfs(depth+1, i);
            }

        }



    }