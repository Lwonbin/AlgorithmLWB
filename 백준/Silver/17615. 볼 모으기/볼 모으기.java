import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        String str = br.readLine();


        //RED공을 왼쪽으로 몰았을 경우
        boolean sw = false;
        int subcnt = 0;

        for(int i=0; i<N; i++){
            if(sw && str.charAt(i)=='R'){
                subcnt++;
                continue;
            }
            if(str.charAt(i)=='B'){
                sw = true;
            }
        }
        cnt = subcnt;


        //RED공을 오른쪽으로 몰았을 경우
        sw = false;
        subcnt = 0;

        for(int i=N-1; i>=0; i--){
            if(sw && str.charAt(i)=='R'){
                subcnt++;
                continue;
            }
            if(str.charAt(i)=='B'){
                sw = true;
            }
        }
        cnt = Math.min(cnt, subcnt);

        // BLUE공을 왼쪽으로 몰았을 경우
        sw = false;
        subcnt = 0;

        for(int i=0; i<N; i++){
            if(sw && str.charAt(i)=='B'){
                subcnt++;
                continue;
            }
            if(str.charAt(i)=='R'){
                sw = true;
            }
        }
        cnt = Math.min(cnt, subcnt);

        // BLUE공을 오른쪽으로 몰았을 경우
        sw = false;
        subcnt = 0;

        for(int i=N-1; i>=0; i--){
            if(sw && str.charAt(i)=='B'){
                subcnt++;
                continue;
            }
            if(str.charAt(i)=='R'){
                sw = true;
            }
        }
        cnt = Math.min(cnt, subcnt);


        System.out.println(cnt);








    }
}
