import java.io.*;
import java.util.*;

public class Main {
    static int[] dist = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new  StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladder = new HashMap<>();
        HashMap<Integer, Integer> snake = new HashMap<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder.put(x, y);
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            snake.put(x,y);
        }


        bfs(1, ladder, snake);



        br.close();
        bw.flush();
        bw.close();
    }


    static void bfs(int start,  HashMap<Integer, Integer> ladder, HashMap<Integer, Integer> snake){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<=6; i++){
                int nx = cur + i;

                if(nx == 100){
                    dist[nx] = dist[cur] + 1;
                    System.out.println(dist[nx]);
                    return;
                }

                if(ladder.containsKey(nx)){
                    nx = ladder.get(nx);
                }else if(snake.containsKey(nx)){
                    nx = snake.get(nx);
                }

                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                    dist[nx] = dist[cur] + 1;
                }


            }
        }
    }
}
