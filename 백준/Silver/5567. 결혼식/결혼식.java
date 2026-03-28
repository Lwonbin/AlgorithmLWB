    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            List<Integer>[] list = new List[n+1];
            for(int i=1; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
                list[to].add(from);
            }

            int[] check = new int[n+1];
            Arrays.fill(check, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(1);
            check[1] = 0;
            int answer = 0;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                if(check[cur] >= 2) continue;

                for(int i : list[cur]){
                    if(check[i] == -1){
                        answer++;
                        queue.add(i);
                        check[i] = check[cur] +1;
                    }
                }
            }

            System.out.println(answer);



        }

    }