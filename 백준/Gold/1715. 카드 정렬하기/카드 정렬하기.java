    import java.io.*;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());



            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<N; i++){
                int C = Integer.parseInt(br.readLine());
                pq.add(C);
            }


            int answer = 0;
            while(pq.size() > 1){
                int first = pq.poll();
                int second = pq.poll();

                int cur = first + second;
                answer += cur;

                pq.add(cur);

            }

            System.out.println(answer);







        }

    }