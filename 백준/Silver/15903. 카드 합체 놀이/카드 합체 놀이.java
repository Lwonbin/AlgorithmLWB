    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            PriorityQueue<Long> pq = new PriorityQueue<>();


            st = new StringTokenizer(br.readLine());
            for(int i= 0; i<n; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            for(int i=0; i<m; i++){
                long cur = pq.poll() + pq.poll();

                pq.add(cur);
                pq.add(cur);
            }


            while(!pq.isEmpty()){
                sum += pq.poll();
            }





            System.out.println(sum);






        }

    }