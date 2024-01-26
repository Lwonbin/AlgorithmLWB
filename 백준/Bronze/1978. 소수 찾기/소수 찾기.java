import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());



        for(int j=0; j<N; j++) {
            int count =0;
            int n = Integer.parseInt(st.nextToken());
            boolean bl = true;

            if(n==1){
                bl = false;
            }
            for (int i = 2; i < n; i++) {

                if (n % i == 0) {
                    bl = false;
                }
            }
            if(bl){
                queue.add(n);
            }
        }
        bw.write(queue.size()+"");



        br.close();
        bw.flush();
        bw.close();
    }
}
