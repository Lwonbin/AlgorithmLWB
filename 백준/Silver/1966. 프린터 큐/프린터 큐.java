import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            StringTokenizer str = new StringTokenizer(br.readLine());

            LinkedList<int[]> q = new LinkedList<>();

            for (int j = 0; j<n; j++) {
                q.add(new int[]{j, Integer.parseInt(str.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] front = q.poll();
                boolean isMax = true;


                for (int x = 0; x < q.size(); x++) {
                    if (front[1] < q.get(x)[1]) {
                        q.offer(front);

                        for (int j = 0; j < x; j++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }


                if (!isMax) {
                    continue;
                }

                count++;

                if (front[0] == m) {
                    break;
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);





    }
}
