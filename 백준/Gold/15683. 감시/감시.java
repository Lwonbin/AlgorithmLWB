import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] arr;
    static List<int[]> cctv;

    static int minBlind = Integer.MAX_VALUE;

    static int[][][] cctvDir = {
            {},
            {{0},{1},{2},{3}},
            {{0,2},{1,3}},
            {{0,1},{1,2},{2,3},{3,0}},
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
            {{0,1,2,3}}
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[N][M];

        cctv = new ArrayList<>();

        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >=1 && arr[i][j] <=5){
                    cctv.add(new int[]{i,j,arr[i][j]});
                }
            }
        }

        dfs(0, arr);


        //0은 빈칸 1~5는 CCTV, 6은 벽

        //1번은 4가지 경우 상하좌우
        //2번은 2가지 경우 상하 / 좌우
        //3번은 4가지 경우 상우 상좌 하우 하좌
        //4번은 4가지 경우 상우좌, 상우하, 하우좌, 하좌상
        //5번은 1가지 경우


        System.out.println(minBlind);




        br.close();
        bw.flush();
        bw.close();

    }


    static void watch(int[][] arr, int y, int x, int dir){
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        int ny = y, nx=x;


        while(true){
            ny += dy[dir];
            nx += dx[dir];

            if(ny>=0 && nx>=0 && ny<N && nx <M){
                if(arr[ny][nx]==6){
                    break;
                }else if(arr[ny][nx]==0){
                    arr[ny][nx]=7;
                }
            }else{
                break;
            }
        }
    }



    static void dfs(int depth, int[][] map) {
        if (depth == cctv.size()) {
            minBlind = Math.min(minBlind, countBlind(map));
            return;
        }

        int[] c = cctv.get(depth);
        int y = c[0], x = c[1], type = c[2];

        for (int[] dirs : cctvDir[type]) {
            int[][] copy = copyMap(map);
            for (int d : dirs) watch(copy, y, x, d);
            dfs(depth + 1, copy);
        }
    }



    static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) copy[i] = original[i].clone();
        return copy;
    }

    static int countBlind(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0) count++;
        return count;
    }
}
