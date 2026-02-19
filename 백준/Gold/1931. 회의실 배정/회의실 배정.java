    import java.io.*;
    import java.util.*;

    public class Main {

        static class Meeting{
            int s,e;

            Meeting(int s, int e){
                this.s = s;
                this.e = e;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


           int N = Integer.parseInt(br.readLine());

           Meeting[] meeting = new Meeting[N];

           for(int i=0; i<N; i++){
               StringTokenizer st = new StringTokenizer(br.readLine());

               int start = Integer.parseInt(st.nextToken());
               int end = Integer.parseInt(st.nextToken());
               meeting[i] = new Meeting(start, end);
           }



           Arrays.sort(meeting, (a,b) ->{
               if(a.e == b.e){
                   return a.s - b.s;
               }
               return a.e - b.e;
           });


           int endTime = 0;
           int answer = 0;
           for(int i=0; i<N; i++){
               if(meeting[i].s >= endTime){
                   answer++;
                   endTime = meeting[i].e;

               }
           }

            System.out.println(answer);



        }
    }