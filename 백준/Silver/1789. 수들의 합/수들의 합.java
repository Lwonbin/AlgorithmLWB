    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            long N = Long.parseLong(br.readLine());

            long answer = 0;

            long sum = 0;
            long idx = 1;
            while(sum != N){
                if(sum+idx <= N){
                    sum+= idx++;
                    answer++;
                }else{
                    break;
                }
            }

            System.out.println(answer);










        }

    }