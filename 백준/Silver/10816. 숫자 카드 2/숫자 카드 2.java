import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st1.nextToken());
            if(h1.containsKey(a)){
                h1.replace(a,h1.get(a)+1);
            }else{
                h1.put(a,1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int j=0; j<M; j++){
            int b = Integer.parseInt(st2.nextToken());
            if(h1.containsKey(b)){
                bw.write(h1.get(b)+" ");
            }else{
                bw.write(0+" ");
            }

        }


        br.close();
        bw.flush();
        bw.close();

    }
}
