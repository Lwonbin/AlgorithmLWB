import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int count = st.countTokens();

        for (int i = 0; i < count; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if(!map2.containsKey(cur)){
                map2.put(cur, i);
            }
            map.put(cur, map.getOrDefault(cur,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) ->{
            if(map.get(o1) == map.get(o2)){
                return map2.get(o1) - map2.get(o2);
            }

            return map.get(o2) - map.get(o1);
        });

        for(int i=0; i<map.size(); i++){
            for(int j=0; j<map.get(list.get(i)); j++){
                bw.write(list.get(i)+" ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
