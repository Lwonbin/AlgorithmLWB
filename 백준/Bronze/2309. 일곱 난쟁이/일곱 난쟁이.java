import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }

        for (int x = 0; x < 8; x++) {
            for(int y= x+1; y<9; y++) {
                if(sum - arr[x] - arr[y]==100){
                    arr[x] = 0;
                    arr[y] = 0;
                    Arrays.sort(arr);
                    for(int z=2; z<9;z++){
                        System.out.println(arr[z]);
                    }
                    return; //없을경우 틀림 하나를 찾고 종료시켜야 하는듯
                }
            }
        }
    }
}
