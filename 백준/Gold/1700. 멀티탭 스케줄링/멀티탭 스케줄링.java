    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            HashSet<Integer> set = new HashSet<>();


            int[] arr = new int[K];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;

            while(idx < K && set.size() < N){
                set.add(arr[idx]);
                idx++;
            }



            int count = 0;
            for(int i = idx; i<K; i++){
                if(!set.contains(arr[i])){
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for(int cur : set){
                        boolean check = true;
                        for(int j = i+1; j<K; j++){
                            if(arr[j] == cur){
                                map.put(cur, j);
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            map.put(cur, Integer.MAX_VALUE);
                        }
                    }
                    List<Integer> list = new ArrayList<>(map.keySet());
                    Collections.sort(list, (o1, o2) ->{
                        return map.get(o2).compareTo(map.get(o1));
                    });


                    set.remove(list.get(0));
                    set.add(arr[i]);
                    count++;
                }

            }










            System.out.println(count);






        }

    }