import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        Stack<Long> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        long count = 0;
        for(int i=0; i<N; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                count += stack.size();
//                System.out.println(count);
                stack.push(arr[i]);
            }
        }


        System.out.println(count);

        br.close();
        bw.flush();
        bw.close();
    }
}
