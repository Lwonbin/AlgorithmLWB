import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static char[][][] map;
    static boolean[][][] visited;
    static int[][][] dist;

    static int L,R,C;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L ==0 && R==0 && C==0){
                break;
            }

            map = new char[L][R][C];
            dist = new int[L][R][C];
            visited = new boolean[L][R][C];

            int startX = 0;
            int startY = 0;
            int startZ = 0;

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String str = br.readLine();

                    for(int k=0; k<C; k++){
                        char cur = str.charAt(k);
                        if(cur == 'S'){
                            startZ = i;
                            startX = j;
                            startY = k;
                        }
                        map[i][j][k] = cur;
                    }
                }
                String Null = br.readLine();
            }


            int result = bfs(startZ, startX, startY);

            if(result == -1){
                bw.write("Trapped!"+"\n");
            }else{
                bw.write("Escaped in " +result+" minute(s)."+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int z, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{z,x,y});
        visited[z][x][y] = true;
        dist[z][x][y] = 0;




        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curZ = cur[0];
            int curX = cur[1];
            int curY = cur[2];

            for(int i=0; i<6; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nz = curZ + dz[i];

                if(nx>=0 && ny>=0 && nz>=0 && nz<L && nx<R && ny<C){
                    if(!visited[nz][nx][ny]){
                        if(map[nz][nx][ny] == 'E'){
                            dist[nz][nx][ny] = dist[curZ][curX][curY] +1;
                            return dist[nz][nx][ny];
                        }else if(map[nz][nx][ny] == '.'){
                            queue.add(new int[]{nz,nx,ny});
                            visited[nz][nx][ny] = true;
                            dist[nz][nx][ny] = dist[curZ][curX][curY] +1;
                        }
                    }
                }
            }
        }


        return -1;

    }
}
