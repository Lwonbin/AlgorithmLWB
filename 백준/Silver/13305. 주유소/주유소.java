import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        int[] dist = new int[N-1];
        int[] cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<N-1; j++){
            cost[j] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        int min = cost[0];

        for(int p=0; p<N-1; p++){
            if(p==0){
                sum = dist[0] * cost[0];
            }else{
                if(min <= cost[p]){
                    sum += min*dist[p];
                }else{
                    min = cost[p];
                    sum += (min * dist[p]);
                }
            }

        }
        bw.write(sum+"");


        br.close();
        bw.flush();
        bw.close();





    }
}
