import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr= new int[N];

        for(int i=1; i<=N; i++){
            map.put(i, Integer.valueOf(st.nextToken()));
        }

        for(int i=N; i>=1; i--){
            list.add(map.get(i),i);
        }

        for(int j=0; j<list.size(); j++){
            bw.write(list.get(j)+" ");
        }


        br.close();
        bw.flush();
        bw.close();

    }
}
