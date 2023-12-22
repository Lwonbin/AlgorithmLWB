import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[21]; // 1부터 20까지의 숫자 사용

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "add":
                        S[num] = 1;
                        break;
                    case "remove":
                        S[num] = 0;
                        break;
                    case "check":
                        bw.write(S[num] + "\n");
                        break;
                    case "toggle":
                        S[num] = (S[num] == 1) ? 0 : 1;
                        break;
                }
            } else {
                switch (command) {
                    case "all":
                        for (int j = 1; j <= 20; j++) {
                            S[j] = 1;
                        }
                        break;
                    case "empty":
                        for (int j = 1; j <= 20; j++) {
                            S[j] = 0;
                        }
                        break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
