import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            list.add(Integer.valueOf(st.nextToken()));
        }

        HashSet<Integer> set = new HashSet<>(list);
        ArrayList<Integer> list2 = new ArrayList<>(set);

        Collections.sort(list2);


        for(int j=0; j<list2.size(); j++){
            if(j==list2.size()-1) {
                bw.write(list2.get(j) + "");
            }else{
                bw.write(list2.get(j)+" ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
