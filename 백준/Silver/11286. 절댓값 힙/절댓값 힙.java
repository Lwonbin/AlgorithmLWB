import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
            //compare함수를 구현할 때 return 값으로 양수를 주면 순서를 바꾸겠다는 것이고 음수이면 바꾸지 않겠다는 것입니다.
            //이때 return 값으로 무조건 1이나 -1을 주어야 하는 것이 아니고 음수나 양수이면 가능합니다.
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if(a>b){
                    return a - b;
                }
                else if(a == b){
                        if(o1>o2){
                            return 1;
                        }else{
                            return -1;
                        }
                }else{
                    return -1;
                }
            }
        });


        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0 && !absHeap.isEmpty()){
                int X = absHeap.poll();
                bw.write(X+"\n");
            }else if(x==0 && absHeap.isEmpty()){
                bw.write("0"+"\n");
            }else{
                absHeap.add(x);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
