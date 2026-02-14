    import java.io.*;
    import java.util.*;

    public class Main {

        static class Job{
            int time;
            int nextCount;

            Job(int time, int nextCount){
                this.time = time;
                this.nextCount = nextCount;
            }
        }

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            List<Integer>[] list = new List[N+1];
            for(int i=0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }

            Job[] indeg = new Job[N+1];

            Deque<Integer> queue = new ArrayDeque<>();

            int[] dp = new int[N+1];


            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int curTime = Integer.parseInt(st.nextToken());
                int nextCount = Integer.parseInt(st.nextToken());

                Job curJob = new Job(curTime, nextCount);

                indeg[i+1] = curJob;



                if(nextCount == 0){
                    queue.add(i+1);
                    dp[i+1] = curTime;
                }


                for(int j=0; j<nextCount; j++){
                    int nextJob = Integer.parseInt(st.nextToken());
                    list[nextJob].add(i+1);
                }
            }

            int answer = 0;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                answer = Math.max(answer, dp[cur]);

                for(int nxt : list[cur]){

                    dp[nxt] = Math.max(dp[nxt], dp[cur] + indeg[nxt].time);
                    indeg[nxt].nextCount--;

                    if(indeg[nxt].nextCount == 0){
                        queue.add(nxt);
                    }
                }

            }

            System.out.println(answer);

        }
    }