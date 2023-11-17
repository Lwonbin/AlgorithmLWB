import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }

        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int z=j+1; z<N; z++){
                    if(arr[i]+arr[j]+arr[z] <= M && arr[i]+arr[j]+arr[z] > sum){
                        sum = arr[i] + arr[j] + arr[z];
                    }
                }
            }
        }
        System.out.println(sum);



    }
}
