    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            HashMap<String, Integer> map = new HashMap<>();

            for(int i=0; i<L; i++){
                String stuNum = br.readLine();
                map.put(stuNum, i);
            }

            List<String> list = new ArrayList<>(map.keySet());

            Collections.sort(list, (o1, o2) -> {
                return map.get(o1) - map.get(o2);
            });

            int idx = 1;
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
                idx++;
                if(idx > K){
                    break;
                }

            }


        }

    }