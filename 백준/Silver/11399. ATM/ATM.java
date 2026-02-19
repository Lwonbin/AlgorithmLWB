    import java.io.*;
    import java.util.*;

    public class Main {

        static class job{
            int num;
            int time;

            job(int num, int time){
                this.num = num;
                this.time = time;
            }
        }


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


           int N = Integer.parseInt(br.readLine());

           job[] ATM = new job[N];

           StringTokenizer st= new StringTokenizer(br.readLine());
           for(int i=0; i<N; i++){
               ATM[i]= new job(i, Integer.parseInt(st.nextToken()));
           }

           Arrays.sort(ATM, (a,b) ->{
               return a.time - b.time;
           });

            int answer = 0;
           int cur = 0;
           for(int i=0; i<N; i++){
               cur += ATM[i].time;
               answer += cur;
           }

            System.out.println(answer);


        }
    }