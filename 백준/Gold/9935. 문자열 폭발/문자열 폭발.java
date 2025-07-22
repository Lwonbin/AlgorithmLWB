import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        String target = br.readLine();
        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            stack.push(cur);
            boolean check = false;

            String curString = "";

            if(stack.size() >= target.length() && cur == target.charAt(target.length()-1)){
                for(int j=target.length()-1; j>=0; j--){
                    if(!stack.isEmpty() && stack.peek() == target.charAt(j)){
                        curString = stack.pop()+curString;
                    }else if(!stack.isEmpty() && stack.peek() != target.charAt(j)){
                        curString = stack.pop() + curString;
                        check = true;
                        break;
                    }
                }
            }
            if(check){
                for(int j=0; j<curString.length(); j++){
                    stack.push(curString.charAt(j));
                }
            }


        }


        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse().toString());
        }





        br.close();
        bw.flush();
        bw.close();
    }
}
