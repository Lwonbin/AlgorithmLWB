    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class student{
            int value;
            int Class;
            int number;

            student(int value, int Class, int number){
                this.value = value;
                this.Class = Class;
                this.number = number;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i =0; i<N; i++){
                Arrays.sort(arr[i]);
            }


            int min = Integer.MAX_VALUE;
            int curMax = 0;
            PriorityQueue<student> pq  = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));

            for(int i=0; i<N; i++){
                pq.add(new student(arr[i][0], i, 0));
                curMax = Math.max(curMax, arr[i][0]);
            }

            while(true){
                student cur = pq.poll();
                min = Math.min(min, Math.abs(curMax-cur.value));

                if(cur.number+1 >= M){
                    break;
                }
                pq.add(new student(arr[cur.Class][cur.number+1], cur.Class, cur.number+1));
                curMax = Math.max(curMax, arr[cur.Class][cur.number+1]);

            }


            System.out.println(min);






        }

    }