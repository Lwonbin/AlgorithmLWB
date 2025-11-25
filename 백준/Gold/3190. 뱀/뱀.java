import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //동 남 서 북
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        String[] Ctl= new String[10001];
        Arrays.fill(Ctl,"A");

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0});

        int AppleCount = Integer.parseInt(br.readLine());


        for(int i=0; i<AppleCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 2;
        }

        int CrlCount = Integer.parseInt(br.readLine());

        for(int i=0; i<CrlCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            Ctl[X] = C;
        }

        map[0][0] = 1;

        int x = 0;
        int y = 0;

        int time = 0;
        int dist = 0;
        while(true){

            if(Ctl[time].equals("L")){
                dist = (dist + 3) % 4;
            }else if(Ctl[time].equals("D")){
                dist = (dist +1) % 4;
            }

            int nx = x+dx[dist];
            int ny = y+dy[dist];

            if(nx<0 || ny<0 || nx>=N || ny >= N || map[nx][ny] == 1){
                time++;
                break;
            }

            if(map[nx][ny] == 0){
                deque.addFirst(new int[]{nx,ny});
                int[] tail = deque.pollLast();
                map[tail[0]][tail[1]] = 0;
                map[nx][ny] = 1;

            }else if(map[nx][ny] == 2){
                deque.addFirst(new int[]{nx,ny});
                map[nx][ny] = 1;
            }
            time++;
            x= nx;
            y=ny;

        }


        System.out.println(time);


        br.close();
    }
}
