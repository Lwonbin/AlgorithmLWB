import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] map = new int[100001];
    static int[] dx = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(map,-1);


        bfs();

        bw.write(map[K] + "");


        br.close();
        bw.flush();
        bw.close();

    }

    static void bfs(){
        Deque<Integer> dq = new LinkedList<>();
        map[N] = 0;
        dq.add(N);
        while(!dq.isEmpty()){
            int cur = dq.poll();
            if(cur == K){
                return;
            }

            for(int i=0; i<3; i++){
                if(i == 0 || i == 1){
                    int nX = cur + dx[i];
                    if(nX>=0 && nX<100001 && (map[nX]==-1 || map[nX] > map[cur])){
                        map[nX] = map[cur] + 1;
                        dq.addLast(nX);

                    }
                }else{
                    int nX = cur * dx[i];
                    if(nX>=0 && nX<100001 && (map[nX]==-1 || map[nX] > map[cur])){
                        map[nX] = map[cur];
                        dq.addFirst(nX);
                    }
                }
            }
        }
    }
}
