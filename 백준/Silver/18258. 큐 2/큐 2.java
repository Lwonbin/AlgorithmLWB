import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[n];
        int front = 0;
        int back = 0;

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                queue[back++] = value;
            } else if (command.equals("front")) {
                if (front == back) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue[front] + "\n");
                }
            } else if (command.equals("pop")) {
                if (front == back) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue[front++] + "\n");
                }
            } else if (command.equals("size")) {
                bw.write((back - front) + "\n");
            } else if (command.equals("empty")) {
                bw.write((front == back ? 1 : 0) + "\n");
            } else if (command.equals("back")) {
                if (front == back) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue[back - 1] + "\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
