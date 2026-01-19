import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int cur = 0;

        for(int i = 0; i < n; i++){
            int N = Integer.parseInt(br.readLine());

            if(N>cur){
                for(int j = cur+1; j <= N; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                cur = N;
            }else if(!stack.isEmpty() && stack.peek() != N){
                System.out.println("NO");
                return;

            }

            stack.pop();
            sb.append("-\n");

        }



        bw.write(String.valueOf(sb));


        br.close();
        bw.flush();
        bw.close();
    }
}
