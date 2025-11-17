import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        HashMap<String, String> map = new HashMap<>();


        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String INOUT = st.nextToken();

            if(INOUT.equals("enter")){
                map.put(name, "enter");
            }else if(INOUT.equals("leave")){
                map.put(name, "leave");
            }

        }


        List<String> list = new ArrayList<>();


        for(String name: map.keySet()){
            if(map.get(name).equals("enter")){
                list.add(name);
            }
        }

        list.sort(Comparator.reverseOrder());


        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }




        br.close();
        bw.flush();
        bw.close();

    }
}
