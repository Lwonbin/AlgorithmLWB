import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> own = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        int sangun_Num = Integer.parseInt(br.readLine());
        int arr1[] = new int[sangun_Num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sangun_Num; i++) {
            own.put(st.nextToken(), 0);
        }

        int check_Num = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int j = 0; j < check_Num; j++) {
            if (own.get(st2.nextToken()) != null) {
                sb.append(1 + " ");
            } else
                sb.append(0+ " ");
        }
            bw.write(sb.toString());


            bw.flush();
            bw.close();
            br.close();


        }
    }
