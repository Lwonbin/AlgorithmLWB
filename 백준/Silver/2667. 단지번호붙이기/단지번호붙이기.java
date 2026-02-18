    import java.io.*;
    import java.util.*;

    public class Main {

        static int[][] map;

        static int[][] dist;

        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

        static int N;

        static int number = 1;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

           StringTokenizer st = new StringTokenizer(br.readLine());

           N = Integer.parseInt(st.nextToken());

           map = new int[N][N];
           dist = new int[N][N];

           for(int i=0; i<N; i++){
               Arrays.fill(dist[i], -1);
           }

           for(int i=0; i<N; i++){
               String str = br.readLine();
               for(int j=0; j<N; j++){
                   map[i][j] = Integer.parseInt(str.charAt(j)+"");
               }
           }



           List<Integer> list = new ArrayList<>();

           for(int i=0; i<N; i++){
               for(int j=0; j<N; j++){
                   if(dist[i][j] == -1 && map[i][j] == 1){
                       int cnt = bfs(i,j, number);
                        number++;
                       list.add(cnt);
                   }
               }
           }

//           for(int i=0; i<N; i++){
//               for(int j=0; j<N; j++){
//                   System.out.print(dist[i][j]+"  ");
//               }
//               System.out.println();
//           }

            Collections.sort(list);
            System.out.println(list.size());

            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }

        }


        static int bfs(int x, int y, int number){
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{x,y});
            dist[x][y] = number;

            int cnt = 1;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int i=0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(nx>=0 && ny>=0 && nx<N && ny<N){
                        if(dist[nx][ny] == -1 && map[nx][ny] == 1){
                            queue.add(new int[]{nx,ny});
                            dist[nx][ny] = number;
                            cnt++;
                        }
                    }


                }

            }

            return cnt;

        }
    }