import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
    static int gcd(int a, int b) { // 최대공약수
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(scan.nextLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            long sum = 0;

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int x = 0; x < n - 1; x++) {
                for (int y = x + 1; y < n; y++) {
                    sum += gcd(arr[x], arr[y]);
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}
