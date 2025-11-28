import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        List<Integer>[] heavys = new ArrayList[N+1];
        List<Integer>[] lights = new ArrayList[N+1];


        for(int i=1; i<=N; i++){
            heavys[i] = new ArrayList<>();
            lights[i] = new ArrayList<>();
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            heavys[heavy].add(light);
            lights[light].add(heavy);

        }



        for(int i =1; i <=N; i++){
            boolean[] visited = new boolean[N+1];
            int heavyCNT = bfs(i, visited, heavys);
            int lightCNT = bfs(i, visited, lights);


            if(heavyCNT >= N/2+1 || lightCNT >= N/2+1){
                answer++;
            }
        }

        System.out.println(answer);



        br.close();


    }

    static int bfs(int i, boolean[] visited, List<Integer>[] list){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        int count = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : list[cur]){
                if(!visited[next]){
                    count++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return count;
    }
}
