import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();

        int answer = 0;

        for(int i=0; i<str.length(); i++){
            if(i<str.length()-1 && str.charAt(i) == 'c'){
                if(str.charAt(i+1) == '='){
                    answer++;
                    i++;
                }else if(str.charAt(i+1) == '-'){
                    answer++;
                    i++;
                }else{
                    answer++;
                }
            }
            else if(str.charAt(i) == 'd'){
                if(i<str.length()-2 && str.charAt(i+1) == 'z' && str.charAt(i+2) == '='){
                    answer++;
                    i++;
                    i++;
                }
                else if(i<str.length()-1 && str.charAt(i+1) == '-'){
                    answer++;
                    i++;
                }else{
                    answer++;
                }
            }
            else if(str.charAt(i) == 'l'){
                if(i<str.length()-1 && str.charAt(i+1) == 'j'){
                    answer++;
                    i++;
                }else{
                    answer++;
                }

            }
            else if(str.charAt(i) =='n'){
                if(i<str.length()-1 && str.charAt(i+1) == 'j') {
                    answer++;
                    i++;
                }else{
                    answer++;
                }
            }

            else if(str.charAt(i) == 's') {
                if (i<str.length()-1 && str.charAt(i + 1) == '=') {
                    answer++;
                    i++;
                } else {
                    answer++;
                }
            }
            else if(str.charAt(i) =='z'){
                if(i<str.length()-1 && str.charAt(i+1) =='='){
                    answer++;
                    i++;
                }else{
                    answer++;
                }
            }else{
                answer++;
            }
        }

        System.out.println(answer);


        br.close();
    }
}
