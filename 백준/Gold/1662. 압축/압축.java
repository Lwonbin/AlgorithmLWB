import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();



        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if (Character.isDigit(str.charAt(i))) {
                if (i+1 < str.length() && str.charAt(i+1) == '(') {
                    stack.push(str.charAt(i) - '0'); // 반복횟수
                } else {
                    stack.push(1); // 그냥 숫자(문자 하나)
                }
            }else if(str.charAt(i) == '('){
                //(를 -1로 표시
                stack.push(-1);
            }else{
                int len = 0;
                while(!stack.isEmpty()){
                    if(stack.peek() != -1){
                        len += stack.pop();
                    }
                    else if(stack.peek() == -1){
                        break;
                    }
                }
                //( 버리기
                stack.pop();
                //(앞에 숫자 count로 저장
                int count = stack.pop();



                stack.push(count* len);


            }
        }


        int size = stack.size();

        int answer = 0;
        for(int i=0; i<size; i++){
            answer += stack.pop();
        }

        System.out.println(answer);







        br.close();

    }
}
