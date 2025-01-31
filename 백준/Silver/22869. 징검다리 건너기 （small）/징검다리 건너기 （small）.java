import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] stone;
    static boolean[] visited;

    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stone = new int[N];
        visited = new boolean[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            stone[i] = Integer.parseInt(st2.nextToken());
        }

        visited[0] = true;
        find(0);
        System.out.println("NO");;



    }

    private static void find(int idx) {
        if (idx == N - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for(int i=N-1; i>idx; i--){
            if(!visited[i]){
                int tmp = (i - idx) * (1+ Math.abs(stone[i]-stone[idx]));

                if(tmp <= K){
                    visited[i] = true;
                    find(i);
                }
            }
        }
    }
}
