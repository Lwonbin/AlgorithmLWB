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

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();

            if (commend.equals("push")) {
                queue.add(Integer.valueOf(st.nextToken()));
            } else if (commend.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else if (commend.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (commend.equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (commend.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else if (commend.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    for (int j = 0; j < queue.size() - 1; j++) {
                        queue.offer(queue.poll());
                    }
                    bw.write(queue.peek() + "\n");
                    queue.offer(queue.poll());

                }
            }


        }

        br.close();
        bw.flush();
        bw.close();
    }
}
