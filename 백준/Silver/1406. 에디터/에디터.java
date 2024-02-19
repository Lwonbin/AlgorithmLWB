import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<Character> LeftStack = new Stack<>();
        Stack<Character> RightStack = new Stack<>();

        for(int j=0; j<str.length(); j++){
            LeftStack.push(str.charAt(j));
        }

        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            String cmd = br.readLine();

            switch (cmd.charAt(0)){
                case 'L':
                    if(LeftStack.empty()) break;
                    RightStack.push(LeftStack.pop());
                    break;
                case 'D':
                    if(RightStack.empty()) break;
                    LeftStack.push(RightStack.pop());
                    break;
                case 'B':
                    if(LeftStack.empty()) break;
                    LeftStack.pop();
                    break;
                case 'P':
                    char n = cmd.charAt(2);
                    LeftStack.push(n);
                    break;
            }
        }

        while(!LeftStack.empty()){
            RightStack.push(LeftStack.pop());
        }

        while(!RightStack.empty()){
            bw.write(RightStack.pop()+"");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
