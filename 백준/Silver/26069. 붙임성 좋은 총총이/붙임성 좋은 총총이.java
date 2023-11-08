import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;
        Set<String> hash = new HashSet<>();
        String chongchong = "ChongChong";
        hash.add(chongchong);

        for(int i=0; i<N; i++){
            String s1 = scan.next();
            String s2 = scan.next();
            if(hash.contains(s1) || hash.contains(s2)){
                hash.add(s1);
                hash.add(s2);
            }

        }
        System.out.println(hash.size());
    }
}
