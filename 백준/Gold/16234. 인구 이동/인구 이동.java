import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int N,L,R;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
                위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
        국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
        연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
                연합을 해체하고, 모든 국경선을 닫는다.
        각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
        */




        while(true){
            boolean moved = false;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        if(bfs(i,j)){
                            moved = true;
                        }
                    }
                }
            }

            if(moved) {
                count++;
            }else{
                break;
            }

        }

        bw.write(count+"");

        br.close();
        bw.flush();
        bw.close();


    }


    static boolean bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {x,y});

        q.add(new int[] {x,y});

        visited[x][y] = true;
        int total = map[x][y];



        while(!q.isEmpty()){



            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]){
                    if(Math.abs(map[curX][curY] - map[nx][ny]) >= L && Math.abs(map[curX][curY] - map[nx][ny]) <= R){
                        q.add(new int[] {nx,ny});
                        list.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        total += map[nx][ny];
                    }
                }
            }


        }

        if(list.size()==1){
            return false;
        }
        total = total / list.size();

        for(int i=0;i<list.size();i++){
            int[] temp = list.get(i);
            map[temp[0]][temp[1]] = total;
        }

        return true;


    }
}
