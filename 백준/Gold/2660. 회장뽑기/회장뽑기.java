import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(map[i], 100);
            map[i][i] = 0;
        }

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(from == -1 && to == -1){
                break;
            }

            map[from][to] = 1;
            map[to][from] = 1;

        }


        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int[] score = new int[N+1];
        int min = Integer.MAX_VALUE;


        for(int i=1; i<=N; i++){
            int max = 0;
            for(int j=1; j<=N; j++){
                max = Math.max(max, map[i][j]);
            }
            score[i] = max;
            min = Math.min(max, min);

        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            if(score[i] == min){
                list.add(i);
            }
        }


        System.out.println(min +" " +list.size());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }




        br.close();

    }
}
