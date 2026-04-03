    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static char[][] map;
        static boolean[][] visited;
        static int[][] fire;

        static int R,C;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            visited = new boolean[R][C];
            fire = new int[R][C];

            for(int i=0; i<R; i++){
                Arrays.fill(fire[i], -1);
            }

            int startX = 0;
            int startY = 0;


            Queue<int[]> fireQueue = new ArrayDeque<>();

            for(int i=0; i<R; i++){
                String str = br.readLine();
                for(int j=0; j<C; j++){
                    map[i][j] = str.charAt(j);
                    if(str.charAt(j) == 'F'){
                        fireQueue.add(new int[]{i,j});
                        fire[i][j] = 0;
                    }else if(str.charAt(j) == 'J'){
                        startX = i;
                        startY = j;
                    }
                }
            }

            while(!fireQueue.isEmpty()){
                int[] cur = fireQueue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int i=0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(nx>=0 && ny>=0 && nx<R && ny<C){
                        if(fire[nx][ny] == -1 && map[nx][ny] != '#'){
                            fire[nx][ny] = fire[curX][curY] +1;
                            fireQueue.add(new int[]{nx,ny});
                        }
                    }
                }
            }

            visited = new boolean[R][C];
            int answer = bfs(startX, startY, 0);
            if(answer == -1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(answer+1) ;
            }

        }

        static int bfs(int x, int y, int count){
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{x,y, count});
            visited[x][y] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int curCount = cur[2];

                if(curX == 0 || curY ==0 || curX ==R-1 || curY == C-1){
                    return curCount;
                }

                for(int i=0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];
                    if(nx>=0 && ny>=0 && nx<R && ny<C){
                        if(!visited[nx][ny] && map[nx][ny] == '.'){
                            if(fire[nx][ny]-1 > curCount || fire[nx][ny] == -1){
                                queue.add(new int[]{nx,ny, curCount+1});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            return -1;

        }


    }