import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(hashMap.containsKey(word) && word.length()>=length){
                hashMap.put(word,hashMap.get(word) + 1);
            }else if(!hashMap.containsKey(word) && word.length()>=length){
                hashMap.put(word, 1);
            }
        }

        List<String> keys = new ArrayList<>(hashMap.keySet());

        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.compare(hashMap.get(o1), hashMap.get(o2)) != 0) {
                    return Integer.compare(hashMap.get(o2), hashMap.get(o1));
                }
                if(o1.length()!=o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });;

        for(String key : keys){
            bw.write(key+"\n");
        }









        br.close();
        bw.flush();
        bw.close();

    }
}
