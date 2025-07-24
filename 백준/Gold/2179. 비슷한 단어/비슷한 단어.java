import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int maxLen = -1;
        int firstIdx = 0;
        int secondIdx = 1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int common = commonPrefix(arr[i], arr[j]);
                if (common > maxLen) {
                    maxLen = common;
                    firstIdx = i;
                    secondIdx = j;
                } else if (common == maxLen) {
                    // 더 빠른 입력 순서를 가진 쌍을 선택
                    if (i < firstIdx || (i == firstIdx && j < secondIdx)) {
                        firstIdx = i;
                        secondIdx = j;
                    }
                }
            }
        }

        System.out.println(arr[firstIdx]);
        System.out.println(arr[secondIdx]);
    }

    static int commonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) cnt++;
            else break;
        }
        return cnt;
    }
}
