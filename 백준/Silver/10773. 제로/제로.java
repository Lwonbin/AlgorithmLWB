import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int sum = 0;

        for(int i=0; i<N; i++){
            int n = scan.nextInt();
            if(n==0){
                stackInt.pop();
            }
            else {
                stackInt.push(n);
            }


        }
        for(int num:stackInt){
            sum += num;
        }
        System.out.println(sum);
    }
}
