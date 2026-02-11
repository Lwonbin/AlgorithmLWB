    import java.io.*;
    import java.util.*;

    public class Main {
        static int N,M;

        static int[][] map;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

        static int answer = 0;

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];


            for(int i=0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while(true){

                boolean[][] outside = makeoutSide();

                List<int[]> melt = new ArrayList<>();

                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(map[i][j] == 1){
                            int cnt = 0;
                            for(int r=0; r<4; r++){
                                int nx = i + dx[r];
                                int ny = j + dy[r];
                                if(outside[nx][ny] && map[nx][ny] == 0){
                                    cnt++;
                                }
                            }
                            if(cnt >=2){
                                melt.add(new int[]{i,j});
                            }
                        }
                    }
                }

                for(int[] cur : melt){
                    int curX = cur[0];
                    int curY = cur[1];
                    map[curX][curY] = 0;
                }


                if(melt.isEmpty()){
                    System.out.println(answer);
                    break;
                }

                answer++;




            }





        }
        static boolean[][] makeoutSide(){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            boolean[][] visited = new boolean[N][M];
            visited[0][0] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int i=0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(nx >=0 && ny>=0 && nx<N && ny<M){
                        if(!visited[nx][ny] && map[nx][ny] == 0){
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx,ny});

                        }
                    }
                }
            }

            return visited;
        }


    }