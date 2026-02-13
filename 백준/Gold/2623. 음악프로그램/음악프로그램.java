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

            List<Integer>[] list = new List[N+1];
            for(int i=0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }
            int[] indeg = new int[N+1];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());

                int prev = Integer.parseInt(st.nextToken());

                for(int j=1; j<k; j++){
                    int cur = Integer.parseInt(st.nextToken());

                    list[prev].add(cur);
                    indeg[cur]++;
                    prev = cur;
                }
            }


            Deque<Integer> queue = new ArrayDeque<>();

            for(int i=1; i<N+1; i++){
                if(indeg[i]==0){
                    queue.add(i);
                }
            }

            int count = 0;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                sb.append(cur).append("\n");
                count++;

                for(int arr : list[cur]){
                    indeg[arr]--;
                    if(indeg[arr] == 0){
                        queue.add(arr);
                    }
                }
            }


            if(count != N){
                System.out.println("0");
            }else{
                System.out.println(sb.toString());
            }

        }
    }