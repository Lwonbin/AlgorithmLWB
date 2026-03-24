    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int[] point = new int[100001];
        static int[] prev = new int[100001];

        static int N,K;

        static int[] dx = { -1, 1, 2};

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            Arrays.fill(prev, -1);
            Arrays.fill(point, -1);


            bfs(N);

            System.out.println(point[K]);
            StringBuilder sb= new StringBuilder();

            int cur = K;
            List<Integer> list = new ArrayList<>();
            while(cur !=N){
                list.add(cur);
                cur = prev[cur];
            }
            list.add(N);
            Collections.reverse(list);

            for(int i : list){
                System.out.print(i+" ");
            }


        }


        static void bfs(int start){
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            point[start] = 0;
            prev[start] = start;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                if(cur==K){
                    break;
                }

                for(int i =0; i<3; i++){
                    int nx = 0;
                    if(i==2){
                        nx = cur * dx[i];
                    }else{
                        nx = cur + dx[i];
                    }

                    if(nx >=0 && nx < 100001){
                        if(point[nx] == -1){
                            point[nx] = point[cur] +1;
                            prev[nx] = cur;
                            queue.add(nx);
                        }
                    }
                }
            }
        }

    }