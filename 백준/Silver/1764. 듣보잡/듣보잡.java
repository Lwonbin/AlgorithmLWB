import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String name = br.readLine();
            map.put(name,map.getOrDefault(name,0)+1);
        }

        for(int j=0; j<m; j++){
            String name = br.readLine();
            map.put(name,map.getOrDefault(name,0)+1);
        }

        for(String str: map.keySet()){
            if(map.get(str)>=2){
                list.add(str);
            }
        }

        Collections.sort(list);

        bw.write(list.size()+"\n");
        for(int q=0; q<list.size(); q++){
            bw.write(list.get(q)+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
