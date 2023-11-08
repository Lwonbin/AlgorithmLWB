import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);

        if(N==1){
            System.out.println(arr[0]*arr[0]);
        }else{
            System.out.println(arr[0]*arr[N-1]);
        }

    }
}
