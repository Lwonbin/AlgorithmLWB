import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();


        for(int i=1; i<=N; i++){
            int current = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[1] < current) stack.pop();

                else{
                    bw.write(stack.peek()[0]+" ");
                    break;
                }
            }

            if(stack.isEmpty()){
                bw.write(0+" ");
            }
            stack.push(new int[] {i, current});
        }


        br.close();
        bw.flush();
        bw.close();

    }
}
