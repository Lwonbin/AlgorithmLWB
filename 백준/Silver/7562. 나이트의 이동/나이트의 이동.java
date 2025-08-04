import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2,-1, 1, 2};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
                int I = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                int curX = Integer.parseInt(st.nextToken());
                int curY = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());

                int targetX = Integer.parseInt(st.nextToken());
                int targetY = Integer.parseInt(st.nextToken());

                int[][] map = new int[I][I];
                boolean[][] visited = new boolean[I][I];

                int result = bfs(I, map, visited, curX, curY, targetX, targetY);
                bw.write(result+"\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }



    static int bfs(int I, int[][] map, boolean[][] visited, int curX, int curY, int targetX, int targetY){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curX, curY});
        visited[curY][curX] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int curx = cur[0];
            int cury = cur[1];


            for(int j=0; j<8; j++){
                int nx = curx + dx[j];
                int ny = cury + dy[j];

                if(nx>=0 && ny>=0 && nx <I && ny <I){
                    if(!visited[ny][nx]){
                        map[ny][nx] = map[cury][curx] + 1;
                        queue.add(new int[]{nx,ny});
                        visited[ny][nx] = true;
                    }else{
                        map[ny][nx] = Math.min(map[ny][nx], map[cury][curx] +1 );
                    }

                }

            }
        }

        return map[targetY][targetX];

    }
}
