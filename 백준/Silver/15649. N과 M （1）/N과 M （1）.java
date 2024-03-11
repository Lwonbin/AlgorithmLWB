import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N =0;
    static int M =0;

    static boolean[] isused;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        isused = new boolean[N];
        arr = new  int[M];
        dfs(0);



        br.close();
        bw.flush();
        bw.close();

    }

    public static void dfs(int depth) throws IOException {
        if(depth == M){
            for(int val : arr){
                bw.write(val+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!isused[i]){
                isused[i]= true;
                arr[depth] = i+1;
                dfs(depth+1);
                isused[i] = false;
            }
        }

    }
}
