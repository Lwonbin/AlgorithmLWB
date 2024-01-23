import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String AC = br.readLine();
            int arrN = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            arr = arr.replace("]","");
            arr = arr.replace("[","");
            Queue<Integer> queue = new LinkedList<>();
            Deque<Integer> deque = new ArrayDeque<>();


            for (String c : arr.split(",")) {
                if (!c.isEmpty()){
                    deque.add(Integer.valueOf(c));
                }
            }

            boolean bl = true;
            boolean isright = true;
            for (char c : AC.toCharArray()) {
                if (c == 'R') {
                    isright = !isright;
                }else if(c=='D') {
                    if (!deque.isEmpty() && isright) {
                        deque.pollFirst();
                    }else if(!deque.isEmpty() && !isright){
                        deque.pollLast();
                    } else{
                        bl = false;

                    }
                }
            }
            if(!bl){
                bw.write("error");
            }else {
                if (!isright) {
                    bw.write("[");
                    while (!deque.isEmpty()) {
                        bw.write(String.valueOf(deque.pollLast()));
                        if (!deque.isEmpty()) {
                            bw.write(",");
                        }
                    }
                    bw.write("]");
                }else{
                    bw.write("[");
                    while (!deque.isEmpty()) {
                        bw.write(String.valueOf(deque.pollFirst()));
                        if (!deque.isEmpty()) {
                            bw.write(",");
                        }
                    }
                    bw.write("]");

                }
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
