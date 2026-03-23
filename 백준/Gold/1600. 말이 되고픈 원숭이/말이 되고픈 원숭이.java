    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int[][] map;
        static int[][][] visited;

        static int K,W,H;

        static int[] dx =  { -1,1,0,0};
        static int[] hdx = { -2, -1, 1, 2, 2, 1, -1, -2};

        static int[] hdy = {1, 2, 2, 1, -1,-2,-2,-1};
        static int[] dy = { 0,0,1,-1};

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            K = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            visited = new int[H][W][K+1];


            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    Arrays.fill(visited[i][j], -1);
                }
            }

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int answer = bfs(0,0);

            System.out.println(answer);







        }

        static int bfs(int x, int y){
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{x,y, 0});
            visited[x][y][0] = 0;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int used = cur[2];

                if(curX == H-1 && curY == W-1){
                    return visited[curX][curY][used];
                }

                for(int i=0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(nx>=0 && ny>=0 && nx<H && ny<W){
                        if(visited[nx][ny][used] == -1 && map[nx][ny] == 0){
                            queue.add(new int[]{nx,ny, used});
                            visited[nx][ny][used] = visited[curX][curY][used] +1;
                        }
                    }
                }

                if(used<K){
                    for(int i=0; i<8; i++){
                        int nx = curX+hdx[i];
                        int ny = curY+hdy[i];

                        if(nx>=0 && ny>=0 && nx<H && ny<W){
                            if(visited[nx][ny][used+1] == -1 && map[nx][ny] == 0){
                                queue.add(new int[]{nx,ny, used+1});
                                visited[nx][ny][used+1] = visited[curX][curY][used] +1;
                            }
                        }
                    }
                }


            }

            return -1;


        }

    }