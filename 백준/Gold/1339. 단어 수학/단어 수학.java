    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class alpah{
            char ap;
            int num;

            alpah(char ap, int num){
                this.ap = ap;
                this.num = num;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            long N = Long.parseLong(br.readLine());

            List<String> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                list.add(br.readLine());
            }

            int[] check = new int[26];




            for(String cur : list){
                int vision = 0;
                if(cur.length() == 1){
                    vision = 1;
                }else{
                    vision = (int)Math.pow(10, cur.length()-1);
                }
                for(int i=0; i<cur.length(); i++){
                    char ch = cur.charAt(i);
                    int curCH = ch-'A';

                    check[curCH] += vision;
                    vision /= 10;

                }
            }

            List<alpah> list2 = new ArrayList<>();

            for(int i=0; i<26; i++){
                if(check[i] != 0){
                    list2.add(new alpah((char)(i+'A'), check[i]));
                }
            }

            Collections.sort(list2, (o1, o2) -> {
                return o2.num - o1.num;
            });


            int[] weight = new int[26];

            int idx = 9;
            for(alpah cur : list2){
                int ch = cur.ap - 'A';
                if(weight[ch] == 0){
                    weight[ch] = idx--;
                }
            }

            int sum = 0;

            for(String cur : list){
                String curSTR = "";
                for(int i = 0; i<cur.length(); i++){
                    int ch = cur.charAt(i) - 'A';
                    curSTR += weight[ch];
                }
                int curSUM = Integer.parseInt(curSTR);
                sum += curSUM;
            }

            System.out.println(sum);








        }

    }