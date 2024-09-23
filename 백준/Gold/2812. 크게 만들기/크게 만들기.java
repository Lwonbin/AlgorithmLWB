import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String num = br.readLine();
        char[] arr = num.toCharArray();

        Stack<Character> stack = new Stack<>();
        int count = 0;
        stack.push(arr[0]);

        for(int i=1; i<N; i++){
            char current = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() < current && count < K) {
                stack.pop();
                count++;
            }
            stack.push(arr[i]);
        }



        StringBuilder str = new StringBuilder();

        for(int i=0; i<N-K; i++){
            str.append(stack.get(i));
        }

        bw.write(str+"");




        br.close();
        bw.flush();
        bw.close();

    }
}
