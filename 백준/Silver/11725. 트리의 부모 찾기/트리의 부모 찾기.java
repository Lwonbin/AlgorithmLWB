import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());
        int[] parent = new int[N+1];

        ArrayList<Integer>[] adj = new ArrayList[N+1];

        for(int i =0; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N + 1];
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(scan.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next:adj[cur]){
                if(visited[next]){
                    continue;
                }
                visited[next] = true;
                queue.add(next);
                parent[next] = cur;
            }
        }

        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }

    }
}
