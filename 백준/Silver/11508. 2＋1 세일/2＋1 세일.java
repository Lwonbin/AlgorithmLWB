    import java.io.*;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());


            Integer[] milk = new Integer[N];
            for(int i=0; i<N; i++){
                int C = Integer.parseInt(br.readLine());
                milk[i] = C;
            }


            Arrays.sort(milk, Collections.reverseOrder());

            int idx = 1;
            int answer = 0;
            for(int cur : milk){
                if(idx % 3 != 0){
                    answer += cur;
                }
                idx++;
            }

            System.out.println(answer);

        }

    }