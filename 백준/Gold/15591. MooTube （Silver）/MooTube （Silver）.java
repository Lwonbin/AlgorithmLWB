import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int to;
        int w;

        Edge(int to, int w){
            this.w = w;
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());



        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Edge>[] USADO = new List[N+1];

        for(int i=0; i<N+1; i++){
            USADO[i] = new ArrayList<>();
        }


        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            USADO[p].add(new Edge(q, r));
            USADO[q].add(new Edge(p, r));

        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cnt = 0;

            boolean[] visited = new boolean[N+1];

            Deque<Integer> dq = new ArrayDeque<>();
            visited[v] = true;
            dq.add(v);

            while(!dq.isEmpty()){
                int cur = dq.pollFirst();

                for(Edge edge: USADO[cur]){
                    int to = edge.to;
                    int w = edge.w;

                    if(!visited[to]){
                        if(w>=k){
                            visited[to] = true;
                            dq.add(to);
                            cnt++;

                        }
                    }
                }
            }

            System.out.println(cnt);

        }






    }




}
