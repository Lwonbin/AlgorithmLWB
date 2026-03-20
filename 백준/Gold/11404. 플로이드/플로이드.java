    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {



        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            int[][] value = new int[N+1][N+1];

            int INF = 100_000_000;

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j){
                        value[i][j] = 0;
                    }else{
                        value[i][j] = INF;
                    }
                }
            }


            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                value[a][b] = Math.min(value[a][b], c);
            }

            for(int k=1; k<=N; k++){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        if(value[i][k] == INF || value[k][j] ==INF) continue;

                        value[i][j] = Math.min(value[i][j], value[i][k] + value[k][j]);
                    }
                }
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(value[i][j] == 100_000_000){
                        System.out.print(0+" ");
                    }else{
                        System.out.print(value[i][j]+" ");
                    }
                }
                System.out.println();
            }






        }

    }