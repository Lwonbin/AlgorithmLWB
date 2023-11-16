import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        StringBuilder result = new StringBuilder();


        for (int j = 0; j < N; j++) {
            Stack<Character> stack = new Stack<>();
            boolean br = true;
            String rhkfgh = scan.next();


            for (int i = 0; i < rhkfgh.length(); i++) {
                if (rhkfgh.charAt(i) == '(') {
                    stack.push(rhkfgh.charAt(i));
                } else if (stack.empty()) {
                    br = false;
                    break;
                } else
                    stack.pop();

            }
            if(stack.empty() && br){
                result.append("YES\n");
            }else
                result.append("NO\n");
        }
        System.out.println(result.toString());
    }
}
