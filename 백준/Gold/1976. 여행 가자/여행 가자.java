import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N,M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }




//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] target = new int[st.countTokens()];

        for(int i=0; i<target.length; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        bfs(target[0]-1);

        for(int i=0; i<target.length; i++){
            if(!visited[target[i]-1]){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");








        br.close();
        bw.flush();
        bw.close();

    }


    static void bfs(int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        visited[target] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0; i<N; i++){
                if(!visited[i] && map[cur][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}

