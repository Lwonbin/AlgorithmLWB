    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int[][] map;
        static boolean[][][] visited;

        static int[][][] count;

        static int N,M,K;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M][K+1];
            count = new int[N][M][K+1];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(str.charAt(j)+"");
                }
            }

            int answer = bfs(0,0, 0);

            System.out.println(answer);

        }

        static int bfs(int x, int y, int breakCnt){
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{x,y,0});
            visited[x][y][0] = true;
            count[x][y][0] = 1;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int curCnt = cur[2];

                if(curX == N-1 && curY == M-1){
                    return count[curX][curY][curCnt];
                }

                for(int i=0; i<4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (map[nx][ny] == 0) {
                            if (!visited[nx][ny][curCnt]) {
                                visited[nx][ny][curCnt] = true;
                                queue.add(new int[]{nx, ny, curCnt});
                                count[nx][ny][curCnt] = count[curX][curY][curCnt] + 1;
                            }
                        } else {
                            if (curCnt < K) {
                                if (!visited[nx][ny][curCnt+1]) {
                                    visited[nx][ny][curCnt+1] = true;
                                    queue.add(new int[]{nx, ny, curCnt + 1});
                                    count[nx][ny][curCnt+1] = count[curX][curY][curCnt] + 1;
                                }
                            }
                        }

                    }

                }
            }

            return -1;

        }

    }