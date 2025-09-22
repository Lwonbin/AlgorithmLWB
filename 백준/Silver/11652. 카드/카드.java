import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long N = Long.parseLong(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            long cur = Long.parseLong(br.readLine());
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        long result = 0;

        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                result = entry.getKey();
            }else if(max == entry.getValue()){
                result = Math.min(result, entry.getKey());
            }
        }

        System.out.println(result);



        br.close();

    }
}
