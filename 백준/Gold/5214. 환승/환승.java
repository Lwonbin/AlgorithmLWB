import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] stations = new List[N+M+1];

        for(int i=0; i<N+M+1; i++){
            stations[i] = new ArrayList<>();
        }




        for(int i=1; i<=M; i++){
            int tubeNode = i+N;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                int station = Integer.parseInt(st.nextToken());
                stations[tubeNode].add(station);
                stations[station].add(tubeNode);
            }
        }


        int answer = bfs(stations);
        System.out.println(answer);
    }


    static int bfs(List<Integer>[] stations){
        if(N == 1) return 1;
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[N+M+1];
        Arrays.fill(dist,-1);
        dist[1] = 1;
        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : stations[cur]){

                if(dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                if(next == N){
                    return dist[N] / 2 + 1;
                }

                queue.add(next);
            }
        }

        return -1;


    }



}
