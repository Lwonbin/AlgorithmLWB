import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        double[] arr = new double[N];
        double sum = 0;
        for(int i=0; i<N;i++){
           double input = scan.nextDouble();
           arr[i] = input;
        }

        double max=0;
        for(int j =0; j<N;j++){
            if(max < arr[j]){
                max = arr[j];
            }
        }

        for(int k=0;k<N; k++){
            arr[k] = arr[k]/max*100;
        }

        for(int x=0;x<N;x++){
            sum += arr[x];
        }
        System.out.println(sum/N);


    }
}
