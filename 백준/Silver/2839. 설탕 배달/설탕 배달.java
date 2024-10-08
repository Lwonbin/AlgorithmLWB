import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        if(N == 4 || N == 7){
            System.out.println(-1);
        }
        else if(N%5 == 0){
            System.out.println(N/5);
        }
        else if(N%5 == 1 || N%5 == 3){
            System.out.println((N/5)+1);
        }

        else if(N % 5 ==2 || N %5 ==4){
            System.out.println((N/5)+2);
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
