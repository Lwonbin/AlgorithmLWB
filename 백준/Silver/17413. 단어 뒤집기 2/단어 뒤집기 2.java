import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray();


        for (int i = 0; i < str.length; i++) {
            if (str[i] == '<') {
                StringBuilder cur = new StringBuilder();
                cur.append('<');
                i++;
                while (true) {
                    if (str[i] == '>') {
                        cur.append('>');
                        break;
                    } else {
                        cur.append(str[i]);
                    }
                    i++;
                }
                sb.append(cur);

            }else if(str[i] ==' '){
                sb.append(' ');
            }

            else{
                StringBuilder cur = new StringBuilder();

                while(true){
                    if(i == str.length || str[i] == ' ' || str[i] == '<'){
                        break;
                    }else{
                        cur.append(str[i]);
                        i++;
                    }
                }
                cur.reverse();
                sb.append(cur);

                i--;
            }
        }


        System.out.println(sb.toString());


    }
}
