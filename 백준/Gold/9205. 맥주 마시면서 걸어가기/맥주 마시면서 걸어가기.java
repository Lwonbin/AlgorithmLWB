import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n + 2][2];

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[j][0] = Integer.parseInt(st.nextToken());
                map[j][1] = Integer.parseInt(st.nextToken());
            }


            boolean check = bfs(map, n);

            if(check){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }


        }

        br.close();

    }


    static boolean bfs(int[][] map, int n){
        boolean[] visited = new boolean[n+2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{map[0][0], map[0][1]});
        visited[0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=1; i<n+2; i++){
                if(!visited[i]){
                    int nx = map[i][0];
                    int ny = map[i][1];
                    int dist = Math.abs(nx - curX) + Math.abs(ny - curY);

                    if(dist <= 1000){
                        if(i == n+1) return true;
                        visited[i] = true;
                        queue.add(new int[]{nx, ny});

                    }


                }
            }
        }

        return false;
    }




}
