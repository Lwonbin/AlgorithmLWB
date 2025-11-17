import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st = new StringTokenizer(br.readLine());

        String ClassOpenTime = st.nextToken();

        String ClassEndTime = st.nextToken();

        String ClassEndStreamTime = st.nextToken();

        HashSet<String> INTER = new HashSet<>();
        HashSet<String> OUTER = new HashSet<>();

        List<String> list = new ArrayList<>();


        String line;
        while ((line = br.readLine()) != null) {
            // 공백만 있는 줄 방지용 (필수는 아니지만 안전빵)
            line = line.trim();
            if (line.isEmpty()) continue;

            st = new StringTokenizer(line);
            String time = st.nextToken();
            String name = st.nextToken();
            list.add(name);

            if(time.compareTo(ClassOpenTime) <=0){
                INTER.add(name);
            }


            if(time.compareTo(ClassEndTime) >=0 && time.compareTo(ClassEndStreamTime)<=0){
                OUTER.add(name);
            }
        }

        int result = 0;

        for(String name : INTER){
            if(OUTER.contains(name)){
                result++;
            }
        }



        System.out.println(result);





        br.close();
        bw.flush();
        bw.close();


    }
}
