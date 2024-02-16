import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 작은 값이 위에 오도록 우선순위 큐 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 큰 값이 위에 오도록 우선순위 큐 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            // maxHeap에 값 추가
            maxHeap.add(number);

            // maxHeap의 최대값을 minHeap으로 이동
            minHeap.add(maxHeap.poll());

            // maxHeap과 minHeap의 크기가 같도록 조정
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // 중간값 출력
            bw.write(maxHeap.peek() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
