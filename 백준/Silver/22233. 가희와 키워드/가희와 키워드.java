import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>();
        StringBuilder sb= new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }



        for(int j=0; j<M; j++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), ",");
            while(st2.hasMoreTokens()){
                String word = st2.nextToken();
                set.remove(word);


            }
            sb.append(set.size() + "\n");
        }

        bw.write(sb.toString());




        br.close();
        bw.flush();
        bw.close();


    }
}
