import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            int[][] arr = new int[number][2];
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();
            HashMap<Integer, Integer> map3 = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < number; j++) {
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = j + 1;
            }

            for (int p = 0; p < number; p++) {
                if (map1.containsKey(arr[p][0])) {
                    map1.put(arr[p][0], map1.get(arr[p][0]) + 1);
                } else {
                    map1.put(arr[p][0], 1);
                }
                if(map1.get(arr[p][0])==5){
                    map3.put(arr[p][0], p);
                }

            }


            map1.entrySet().removeIf(entry -> entry.getValue() < 6);

            for( int q=0; q<number; q++){
                if(!map1.containsKey(arr[q][0])){
                    for(int p=q; p<number-1;p++){
                        arr[p+1][1]--;

                    }
                }
            }
            int[] count = new int[arr.length];

            for(int t=0; t<arr.length; t++) {
                if (map2.containsKey(arr[t][0])) {
                    if (count[arr[t][0]] < 4) {
                        map2.put(arr[t][0], map2.get(arr[t][0]) + arr[t][1]);
                        count[arr[t][0]]++;
                    }
                }else {
                    count[arr[t][0]] = 1;
                    map2.put(arr[t][0], arr[t][1]);
                }
            }



            map2.entrySet().removeIf(entry -> !map1.containsKey(entry.getKey()));

            List<Integer> keySetList = new ArrayList<>(map2.keySet());
            Collections.sort(keySetList, Comparator.comparing(map2::get));

            int most_small = keySetList.get(0);
            for(int z=1; z<keySetList.size(); z++){
                if(Objects.equals(map2.get(most_small), map2.get(keySetList.get(z)))){
                    if(map3.get(most_small) > map3.get(keySetList.get(z))){
                        most_small = keySetList.get(z);
                    }
                }else{
                    break;
                }
            }

            bw.write(most_small+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
