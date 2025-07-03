import java.io.*;
import java.util.*;


public class Main {
    static int N,M,H;
    static int[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0 , 1, -1};
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int [H][N][M];

        Queue<int[]>  q = new LinkedList<>();

        for(int i=0; i< H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.add(new int[] {i,j,k});
                    }
                }
            }
        }



        bfs(q);

//        for(int i=0; i< H; i++){
//            for(int j=0; j< N; j++){
//                for(int k=0; k<M; k++){
//                    System.out.print(map[i][j][k]);
//                }
//                System.out.println();
//            }
//
//        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i< H; i++){
            for(int j=0; j< N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        System.exit(0);
                    }else{
                        max = Math.max(max, map[i][j][k]);
                    }

                }
            }

        }

        System.out.println(max-1);





        br.close();
        bw.flush();
        bw.close();

    }

    static void bfs(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curZ = cur[0];
            int curY = cur[1];
            int curX = cur[2];

            for(int i=0; i<6; i++){
                int nz = curZ + dz[i];
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(nx>=0 && ny>=0 && nz>=0 && nx<M && ny<N && nz<H){
                    if(map[nz][ny][nx] == 0){
                        queue.add(new int[] {nz,ny,nx});
                        map[nz][ny][nx] = map[curZ][curY][curX]+1;

                    }
                }

            }
        }
    }
}
