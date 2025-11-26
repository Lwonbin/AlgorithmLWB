import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = "";

        while((str = br.readLine())!=null){

            if(str.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<str.length() ;i++){
                if(str.charAt(i)=='(' || str.charAt(i)=='['){
                    stack.push(str.charAt(i));
                }else if(str.charAt(i) ==')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(str.charAt(i));
                    }
                }else if(str.charAt(i) == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        stack.push(str.charAt(i));
                    }
                }
            }

            if(stack.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }


        br.close();

    }
}
