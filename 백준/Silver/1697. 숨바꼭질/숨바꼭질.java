import java.io.*;
import java.util.*;
public class Main {
    static int K;
    static int N;

    static int[] visited = new int[100001];

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        result = bfs(N);

        bw.write(result+"");



        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int node){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        int index = node;
        int n = 0;

        visited[index] = 1;

        while(!queue.isEmpty()){
            n = queue.remove();


            if(n == K){
                return visited[n] -1;
            }

            if(n-1 >=0 && visited[n-1] == 0){
                visited[n-1] = visited[n]+1;
                queue.add(n-1);

            }

            if(n+1<=100000 && visited[n+1] == 0){
                visited[n+1] = visited[n]+1;
                queue.add(n+1);
            }

            if(n*2 <= 100000 && visited[n*2]==0){
                visited[n*2] = visited[n] +1;
                queue.add(n*2);
            }
        }

        return -1;

    }
}
