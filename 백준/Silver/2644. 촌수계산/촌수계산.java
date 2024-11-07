import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static boolean[] visited;

    static int targetNum1, targetNum2,n;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        targetNum1 = Integer.parseInt(st.nextToken());
        targetNum2 = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        map = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st2.nextToken());
            int V2 = Integer.parseInt(st2.nextToken());
            map[V1][V2] = true;
            map[V2][V1] = true;
        }
        dfs(targetNum1, 0);

        bw.write(answer+"");


        br.close();
        bw.flush();
        bw.close();

    }


    public static void dfs(int targetNum, int count){


        visited[targetNum] = true;

        if(targetNum == targetNum2){
            answer = count;
        }

        for(int i=1; i<=n; i++){
            if(map[targetNum][i] && !visited[i]) dfs(i, count+1);
        }
    }
}
