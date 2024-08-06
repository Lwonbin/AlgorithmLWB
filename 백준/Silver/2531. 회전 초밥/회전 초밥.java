import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] eated = new int[d + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (eated[sushi[i]] == 0) {
                count++;
            }
            eated[sushi[i]]++;
        }

        int maxLen = count;

        for (int i = 0; i < N; i++) {
            if (eated[coupon] == 0) {
                maxLen = Math.max(maxLen, count + 1);
            } else {
                maxLen = Math.max(maxLen, count);
            }

            // 윈도우의 시작과 끝을 각각 이동
            int start = i;
            int end = (i + k) % N;

            eated[sushi[start]]--;
            if (eated[sushi[start]] == 0) {
                count--;
            }

            if (eated[sushi[end]] == 0) {
                count++;
            }
            eated[sushi[end]]++;
        }

        System.out.println(maxLen);
        br.close();
    }
}
