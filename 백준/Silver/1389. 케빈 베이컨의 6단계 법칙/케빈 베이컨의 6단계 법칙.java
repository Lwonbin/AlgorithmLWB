import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] score = new int[N+1];


        int[][] graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(graph[i], 100000);
            graph[i][i] = 0;
        }



        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
            graph[to][from] = 1;

        }

        for(int k=1; k<N+1; k++){
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }


        int minBenefit = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += graph[i][j];
            }
            minBenefit = Math.min(minBenefit, sum);
            score[i] = sum;
        }

        for(int i=1; i<=N; i++){
            if(score[i]==minBenefit){
                System.out.println(i);
                break;
            }
        }






        br.close();

    }
}
