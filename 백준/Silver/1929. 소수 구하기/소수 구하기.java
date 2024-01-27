import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean bl;

        for(int i=M; i<=N; i++){
            bl = isPrime(i);

            if(bl && i<N){
                bw.write(i+"\n");
            }else if(bl && i==N){
                bw.write(i+"");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
    private static boolean isPrime(int num){
        if(num<2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i==0){
                return false;
            }
        }
        return true;
    }
}
