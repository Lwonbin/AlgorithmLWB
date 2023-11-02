import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = scan.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i =1; i<N+1; i++){
            queue.offer(i);
        }
        System.out.print("<");

        for(int j =0; j<N-1; j++){ // 수정된 부분: N-1번 반복
            for(int t =0; t<X-1; t++){
                queue.offer(queue.poll());
            }
            System.out.print(queue.poll()+ ", ");
        }
        System.out.println(queue.poll() + ">"); // 마지막 원소는 쉼표를 붙이지 않고 출력
    }
}
