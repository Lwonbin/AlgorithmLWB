import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        Set<String> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            if (s.equals("ENTER")) {
                hash.clear();
            } else {
                if (hash.contains(s)) continue;
                hash.add(s);
                count++;
            }
        }
        System.out.println(count);
    }
}