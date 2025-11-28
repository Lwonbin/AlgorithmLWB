import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1; i<=N ;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[B].add(A);
        }

        int[] value = new int[N+1];

        int max = 0;
        for(int i=1; i<=N; i++){
            boolean[] visited = new boolean[N+1];
            int count = bfs(i, visited);
            max = Math.max(max, count);
            value[i] = count;
        }

        for(int i=1; i<=N; i++){
            if(value[i]==max){
                System.out.print(i+" ");
            }
        }




        br.close();
    }

    static int bfs(int i, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        int count = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next: list[cur]){
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
