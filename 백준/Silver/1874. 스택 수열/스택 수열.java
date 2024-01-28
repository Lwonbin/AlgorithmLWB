import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> intStack = new Stack<>();
        int start = 0;

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > start){
                for(int j=start+1; j<=n;j++){
                    intStack.push(j);
                    sb.append("+").append("\n");
                }
                start = n;
            }else if(intStack.peek() != n){
                System.out.println("NO");
                return;
            }

            intStack.pop();
            sb.append("-").append("\n");
        }
        bw.write(String.valueOf(sb));





        br.close();
        bw.flush();
        bw.close();






    }
}
