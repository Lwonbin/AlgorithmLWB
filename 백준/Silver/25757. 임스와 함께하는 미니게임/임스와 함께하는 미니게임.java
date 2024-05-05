import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<String>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        if(game.equals("Y")){
            bw.write(set.size()+"");
        }else if(game.equals("F")){
            bw.write(set.size()/2+"");
        }else if(game.equals("O")){
            bw.write(set.size()/3+"");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
