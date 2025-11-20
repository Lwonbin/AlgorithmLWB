import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if(S==G){
            System.out.println(0);
            return;
        }
        
        int[] dx = new int[]{U,-D};


        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        boolean[] visited = new boolean[F+1];
        visited[S] = true;
        int[] count = new int[F+1];
        count[S] = 0;

        int result = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i=0; i<2; i++){
                int nextStair = cur + dx[i];

                if(nextStair == G){
                    result = count[cur] + 1;
                    break;
                }

                if(nextStair >=1 && nextStair <= F) {
                    if (!visited[nextStair]) {
                        visited[nextStair] = true;
                        count[nextStair] = count[cur] + 1;
                        queue.add(nextStair);
                    }
                }
            }
        }

        if(result == 0){
            System.out.println("use the stairs");
        }else{
            System.out.println(result);
        }




        br.close();
        bw.flush();
        bw.close();
    }
}
