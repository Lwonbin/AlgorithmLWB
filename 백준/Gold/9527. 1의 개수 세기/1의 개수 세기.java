import java.io.*;
import java.util.*;

public class Main {

    static long countOnesUpTo(long n) {
        if (n < 0) return 0;  // A가 0일 때 A-1 처리용
        long ans = 0;
        long N = n + 1;       // 0..n 개수

        for (int k = 0; k <= 60; k++) {
            long half = 1L << k;       // 2^k
            long cycle = half << 1;    // 2^(k+1)

            long full = N / cycle;
            long rem = N % cycle;

            ans += full * half;
            long extra = rem - half;
            if (extra > 0) ans += extra;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long answer = countOnesUpTo(B) - countOnesUpTo(A - 1);
        System.out.println(answer);
    }
}