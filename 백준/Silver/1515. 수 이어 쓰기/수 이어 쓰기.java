import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int pointer = 0; // 수열 포인터
        int ans = 0; // 결과값
        while (ans++ <= 30000) {
            String tmp = String.valueOf(ans);

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pointer)) {
                    pointer++;
                }
                if (pointer == s.length()) {
                    bw.write(ans+"");

                    br.close();
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }



    }
}
