import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken());
       int C = Integer.parseInt(st.nextToken());

       st= new StringTokenizer(br.readLine());
       HashMap<Integer, Integer> map = new HashMap<>();

       HashMap<Integer, Integer> map2 = new HashMap<>();




       for(int i =0; i<N; i++){
           int cur = Integer.parseInt(st.nextToken());
           map.put(cur, map.getOrDefault(cur, 0)+1);
           if(!map2.containsKey(cur)){
               map2.put(cur, i);
           }


       }

       List<Integer> list = new ArrayList<>(map.keySet());

       list.sort((o1,o2) -> {
           int cmp = map.get(o2).compareTo(map.get(o1));
           if(cmp == 0){
               return map2.get(o1).compareTo(map2.get(o2));
           }
           return cmp;

       });


       for(int i=0; i<list.size(); i++){
           for(int j=0; j<map.get(list.get(i)); j++){
               System.out.print(list.get(i)+" ");
           }
       }



        br.close();
        bw.flush();
        bw.close();

    }
}
