import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cur = 1000 - N;

        int count = 0;
        while(cur != 0){

            if(cur >= 500){
                cur -= 500;
                count++;
            }else if(cur >=100){
                cur -= 100;
                count++;
            }else if(cur >= 50){
                cur -= 50;
                count++;
            }else if(cur >=10){
                cur -= 10;
                count++;
            }else if(cur >= 5){
                cur -= 5;
                count++;
            }else if(cur >= 1){
                cur -= 1;
                count++;
            }
        }

        System.out.println(count);


        br.close();
    }
}
