    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<Integer, String> number = new HashMap<>();
            HashMap<String, Integer> count = new HashMap<>();

            for(int i=0; i<N; i++){
                String name  = br.readLine();

                number.put(i+1, name);
                count.put(name, i+1);
            }

            for(int i=0; i<M; i++){
                String cur = br.readLine();

                boolean check = true;
                for(int j=0; j<cur.length(); j++){
                    if(cur.charAt(j)-'0' >= 0 && cur.charAt(j)-'0' <=9){
                        check = false;
                    }
                }

                if(!check){
                    int numCur = Integer.parseInt(cur);
                    System.out.println(number.get(numCur));
                }else{
                    System.out.println(count.get(cur));
                }


            }


        }

    }