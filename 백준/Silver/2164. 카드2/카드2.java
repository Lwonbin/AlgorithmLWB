import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i =1; i<N+1; i++){
            queue.offer(i);
        }
        while(queue.size()>1){
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
