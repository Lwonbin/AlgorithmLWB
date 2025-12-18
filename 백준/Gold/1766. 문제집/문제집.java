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

        List<Integer>[] solve = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            solve[i] = new ArrayList<>();
        }

        int[] indeg = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int preSolve = Integer.parseInt(st.nextToken());
            int lateSolve = Integer.parseInt(st.nextToken());
            solve[preSolve].add(lateSolve);
            indeg[lateSolve]++;
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            if(indeg[i] == 0){
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for(int next:solve[cur]){
                indeg[next]--;
                if(indeg[next] == 0){
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);





        br.close();

    }
}
