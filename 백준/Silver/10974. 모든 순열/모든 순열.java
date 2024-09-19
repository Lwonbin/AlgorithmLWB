import java.io.*;
public class Main {
    public static int N;
    public static int[] arr;
    public static boolean[] visit;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];

        dfs(0);




    }

    private static void dfs(int cnt) throws IOException {
        if(cnt ==N){
            for(int i=0; i<N; i++){
                System.out.print((arr[i]+" "));
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                arr[cnt] = i+1;
                visit[i] = true;
                dfs(cnt+1);
                visit[i] = false;
            }
        }


    }
}
