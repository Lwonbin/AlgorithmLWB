import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            dq.addLast(i);
        }

        int answer = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;

            for(int v : dq){
                if(v == target){
                    break;
                }
                idx++;
            }


            int size = dq.size();
            int left = idx;
            int right = size - idx;

            if(left <= right){
                for(int j=0; j<left; j++){
                    dq.addLast(dq.pollFirst());
                }
                answer += left;
            }else{
                for(int j=0; j<right; j++){
                    dq.addFirst(dq.pollLast());
                }
                answer += right;
            }


            dq.pollFirst();
        }

        System.out.println(answer);








        br.close();
        bw.flush();
        bw.close();
    }


}