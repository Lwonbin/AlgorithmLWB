import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Character> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while(N>0){
            if(N%B < 10){
                list.add((char) (N%B+'0'));
            }else{
                list.add((char)(N%B-10 + 'A'));
            }

            N /= B;
        }

        for(int i=list.size()-1; i>=0; i--){
            bw.write(list.get(i));
        }
        bw.flush();
        bw.close();
        br.close();



    }
}
