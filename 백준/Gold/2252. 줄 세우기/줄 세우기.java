    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer>[] array = new List[N+1];
            int[] indeg = new int[N+1];


            for(int i=0; i<N+1; i++){
                array[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                array[A].add(B);
                indeg[B]++;

            }


            Deque<Integer> deque = new ArrayDeque<>();

            for(int i=1; i<=N; i++){
                if(indeg[i] == 0){
                    deque.add(i);
                }
            }




            while(!deque.isEmpty()){
                int cur = deque.poll();

                sb.append(cur).append(" ");

                for(int abc : array[cur]){
                    indeg[abc]--;
                    if(indeg[abc]==0){
                        deque.add(abc);
                    }
                }
            }

            System.out.println(sb.toString());


        }
    }