import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> room = new PriorityQueue<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });




        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new int[]{start, end});
        }

        room.add(0);


        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(room.peek() <= cur[0]){
                room.poll();
            }
            room.add(cur[1]);

        }


        System.out.println(room.size());






        br.close();
        bw.flush();
        bw.close();
    }
}
