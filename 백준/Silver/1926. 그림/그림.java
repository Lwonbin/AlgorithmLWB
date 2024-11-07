import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] map;
    static boolean[][] visited;

    static int n,m;

    static ArrayList<Integer> list;
    static Queue<int []> queue;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st2.nextToken());

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i, j);
                    list.add(area);
                } // if
            } // for
        } // for


        Collections.sort(list);

        bw.write(list.size()+"\n");

        if(list.isEmpty()){
            bw.write("0");
        }else{
            bw.write(list.get(list.size()-1)+"");
        }




        br.close();
        bw.flush();
        bw.close();
    }


    public static int bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        int sum = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<4; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if(mx<0 || mx>=n || my<0 || my>=m){
                    continue;
                }

                if(map[mx][my]==1 && !visited[mx][my]){
                    queue.add(new int[]{mx,my});
                    visited[mx][my] = true;
                    sum++;
                }
            }
        }

        return sum;
    }
}
