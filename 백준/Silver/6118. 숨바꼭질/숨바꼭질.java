
import java.awt.font.GlyphJustificationInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);

        }


        int[] dist = new int[N+1];

        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] +1;
                    queue.add(next);
                }
            }
        }

        int maxValue = 0;
        for(int i=1; i<N+1; i++){
            maxValue = Math.max(maxValue, dist[i]);
        }


        int maxCount = 0;
        int maxIndex = 0;
        for(int i=1; i<N+1; i++){
            if(dist[i] == maxValue) maxCount++;
        }

        for(int i=1; i<N+1; i++){
            if(dist[i] == maxValue){
                maxIndex = i;
                break;
            }
        }


        System.out.println(maxIndex +" " +maxValue +" "+ maxCount);






        br.close();
    }
}
