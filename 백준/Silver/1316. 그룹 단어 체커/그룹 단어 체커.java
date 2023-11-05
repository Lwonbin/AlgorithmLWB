import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;

        for (int i = 0; i < N+1; i++) {
            int last = 0;
            String str = scan.nextLine();
            char[] arr = str.toCharArray();

            if (str.length() <= 2) {
                count++;
                continue;
            }

            outerLoop:
            for (int k = 0; k < str.length()-1; k++) {
                if(arr[k] == arr[k+1]){
                    continue;
                }
                else{
                    for (int j = 0; j<k; j ++){
                        if(arr[j] == arr[k+1]){
                            last ++;
                            break outerLoop;
                        }
                    }
                }
            }
            if(last ==0){
                count ++;
            }

        }
        System.out.println(count-1);

    }
}

