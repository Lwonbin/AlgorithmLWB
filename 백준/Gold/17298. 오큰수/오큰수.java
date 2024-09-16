import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());



        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] real = new int[N];

        for(int i=0; i<N; i++){
            real[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();


        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && real[stack.peek()] < real[i]){
                real[stack.pop()] = real[i];
            }
            stack.push(i);
        }


        while(!stack.isEmpty()){
            real[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++){
            bw.write(real[i]+" ");
        }





        br.close();
        bw.flush();
        bw.close();
    }
}
