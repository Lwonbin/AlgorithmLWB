    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            int minusCnt = 0;
            int plusCnt = 0;
            int zeroCnt = 0;
            int oneCnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                int cur = Integer.parseInt(br.readLine());
                if(cur < 0){
                    minusCnt++;
                    pq.add(cur);
                }else if(cur == 1){
                    oneCnt++;
                }else if(cur >0){
                    plusCnt++;
                    pq.add(cur);
                }
                else{
                    zeroCnt++;
                }

            }


            int[] minus = new int[minusCnt];
            Integer[] plus = new Integer[plusCnt];

            int idx = 0;
            for(int i=0; i<minusCnt; i++){
                minus[i] = pq.poll();
            }

            for(int i=0; i<plusCnt; i++){
                plus[i] = pq.poll();
            }

            Arrays.sort(plus, Collections.reverseOrder());


            long sum = 0;

            sum += oneCnt;


            for(int i=0; i<minusCnt-1; i+=2){
                sum += minus[i] * minus[i+1];
            }

            if(minusCnt % 2 == 1){
                if(zeroCnt == 0){
                    sum += minus[minusCnt-1];
                }else{
                    zeroCnt--;
                }
            }


            for(int i=0; i<plusCnt-1; i+=2){
                sum += plus[i] * plus[i+1];
            }

            if(plusCnt % 2 == 1){
                sum += plus[plusCnt-1];
            }


            System.out.println(sum);







        }

    }