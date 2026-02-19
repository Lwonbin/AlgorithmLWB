    import java.io.*;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


           int N = Integer.parseInt(br.readLine());

           List<Integer>[] computer = new List[N+1];

           for(int i=0; i<=N; i++){
               computer[i] = new ArrayList<>();
           }

           int M = Integer.parseInt(br.readLine());
           for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                computer[A].add(B);
                computer[B].add(A);
           }


            boolean[] visited = new boolean[N+1];
           Queue<Integer> queue = new ArrayDeque<>();
           queue.add(1);

           int answer = 0;

           visited[1] = true;

           while(!queue.isEmpty()){
               int cur = queue.poll();

               for(int nxt : computer[cur]){
                   if(!visited[nxt]){
                       queue.add(nxt);
                       visited[nxt] = true;
                       answer++;
                   }
               }
           }

            System.out.println(answer);
        }
    }