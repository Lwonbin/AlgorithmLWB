    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String str = br.readLine();
            String boom = br.readLine();

            Stack<Character> stack = new Stack<>();

            int idx = 0;
            while(true){
                stack.push(str.charAt(idx));

                if(!stack.isEmpty() && stack.peek() == boom.charAt(boom.length()-1)){
                    String cur = "";
                    for(int i=0; i<boom.length(); i++){
                        if(!stack.isEmpty()){
                            cur = stack.pop() + cur;
                        }
                    }
                    if(!cur.equals(boom)){
                        for(int i=0; i<cur.length(); i++){
                            stack.push(cur.charAt(i));
                        }
                    }
                }

                idx++;

                if(idx >= str.length()){
                    break;
                }
            }


            StringBuilder sb = new StringBuilder();
            if(!stack.isEmpty()){
                for(char ch : stack){
                    sb.append(ch);
                }
            }else{
                sb.append("FRULA");
            }

            System.out.println(sb.toString());


        }
    }