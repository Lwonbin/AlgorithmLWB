    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int[] number = new int[1000001];
        static int[] prev = new int[1000001];

        static int[] dx = {3,2,1};


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            Arrays.fill(number, -1);
            Arrays.fill(prev, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(N);
            number[N] = 0;
            prev[N] = N;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                if(cur == 1){
                    break;
                }



                for(int i=0; i<3; i++){
                    int nx = 0;
                    if(i==2){
                        nx = cur - dx[i];
                    }else{
                        if(cur % dx[i] == 0){
                            nx = cur / dx[i];
                        }
                    }

                    if(nx >= 0 && nx <= 1000000){
                        if(number[nx] == -1){
                            number[nx] = number[cur] +1;
                            prev[nx] = cur;
                            queue.add(nx);
                        }
                    }
                }
            }

            System.out.println(number[1]);

            List<Integer> list = new ArrayList<>();
            int cur = 1;
            while(cur != N){
                list.add(cur);
                cur = prev[cur];
            }

            list.add(N);
            Collections.reverse(list);

            for(int i : list){
                System.out.print(i+" ");
            }


        }

    }