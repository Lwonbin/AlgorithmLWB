import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();

            map.put(str, str.length());
        }


        List<String> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> {
            if(map.get(o1) == map.get(o2)){
                return o1.compareTo(o2);
            }

            return map.get(o1) - map.get(o2);
        });

        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
