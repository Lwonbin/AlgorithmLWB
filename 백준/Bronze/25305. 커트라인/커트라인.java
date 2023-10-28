import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[N];
        int swap;
        for(int x = 0; x < N; x++){
            arr[x] = scan.nextInt();
        }
        for(int j=0; j<N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = swap;
                }
            }
        }

            System.out.println(arr[N-k]);
    }
}
