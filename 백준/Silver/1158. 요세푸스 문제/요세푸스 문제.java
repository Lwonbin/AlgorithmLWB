    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

           StringTokenizer st = new StringTokenizer(br.readLine());

           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());

           Queue<Integer> queue = new ArrayDeque<>();

           for(int i=0; i<N; i++){
               queue.add(i+1);
           }

           int idx = 1;

           StringBuilder sb = new StringBuilder();
           sb.append("<");
           while(!queue.isEmpty()){
               if(idx % M == 0){
                   sb.append(queue.poll());
                   if(!queue.isEmpty()){
                       sb.append(", ");
                   }
               }else{
                   queue.add(queue.poll());
               }



               idx++;
           }

            sb.append(">");
            System.out.println(sb);



        }
    }