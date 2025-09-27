import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int cur = 0;
            for(int j=0; j<N; j++){
                if(arr[j] > arr[i]){
                    cur += arr[j] - arr[i];
                }else{
                    cur += arr[i] - arr[j];
                }
            }
            map.put(arr[i], cur);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (o1,o2) ->{
            int cmp = map.get(o1) - map.get(o2);
            if(cmp == 0){
                return o1 - o2;
            }
            return cmp;
        });

        System.out.println(list.get(0));


    }
}
