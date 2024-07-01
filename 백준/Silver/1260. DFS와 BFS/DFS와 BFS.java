import java.io.*;
import java.util.*;
public class Main {
    static boolean[] check;
    static int[][] arr;

    static int node;
    static int line;
    static int start;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i=0; i<line; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");

        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);





    }
    public static void dfs(int start){
        check[start] = true;
        sb.append(start + " ");

        for(int i=1; i<=node; i++){
            if(arr[start][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        queue.add(start);
        check[start] = true;

        while(!queue.isEmpty()){

            start = queue.poll();
            sb.append(start + " ");

            for(int i=1; i<=node; i++){
                if(arr[start][i] == 1 && !check[i]){
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
