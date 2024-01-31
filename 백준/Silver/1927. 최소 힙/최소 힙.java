import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x>0){
                minHeap.add(x);
            }else if(x==0 && !minHeap.isEmpty()){
                int X = minHeap.poll();
                bw.write(X+"\n");
            }else if(x==0 && minHeap.isEmpty()){
                bw.write("0"+"\n");
            }
        }




        br.close();
        bw.flush();
        bw.close();
    }
}
