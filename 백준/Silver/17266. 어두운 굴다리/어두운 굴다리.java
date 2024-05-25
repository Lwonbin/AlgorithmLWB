import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수
        int[] arr = new int[M]; // 가로등 설치 위치

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = N;
        int result = N;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canIlluminate(N, arr, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean canIlluminate(int N, int[] arr, int length) {
        int current = 0;
        for (int pos : arr) {
            if (pos - length > current) {
                return false;
            }
            current = pos + length;
        }
        return current >= N;
    }
}
