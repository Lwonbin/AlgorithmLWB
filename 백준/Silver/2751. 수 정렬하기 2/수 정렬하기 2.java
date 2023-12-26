import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> integerSet = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            integerSet.add(num);
        }
        ArrayList<Integer> al = new ArrayList<>(integerSet);
        Collections.sort(al);

        for (int j = 0; j < al.size(); j++) {
            bw.write(al.get(j) + "\n");;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
