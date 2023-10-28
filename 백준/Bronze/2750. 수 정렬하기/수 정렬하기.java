import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] arr = new int[N];
        int swap;
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
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
        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        };


    }
}
