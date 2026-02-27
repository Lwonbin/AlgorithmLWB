    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class Box{
            int from;
            int to;
            int cnt;

            Box(int from, int to, int cnt){
                this.from = from;
                this.to = to;
                this.cnt = cnt;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());

            List<Box> city = new ArrayList<>();
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int fromVillage = Integer.parseInt(st.nextToken());
                int toVillage = Integer.parseInt(st.nextToken());
                int boxCnt = Integer.parseInt(st.nextToken());

                city.add(new Box(fromVillage, toVillage, boxCnt));

            }

            Collections.sort(city, (o1, o2) -> {
                if(o1.to == o2.to){
                    return Integer.compare(o1.from, o2.from);
                }
                return Integer.compare(o1.to, o2.to);
            });

            int[] remain = new int[N];
            Arrays.fill(remain, C);

            int count = 0;

            for(Box curBox : city){
                int minRemain = Integer.MAX_VALUE;

                for(int i= curBox.from; i<curBox.to; i++){
                    minRemain = Math.min(minRemain, remain[i]);
                }

                int take = Math.min(curBox.cnt, minRemain);
                if(take == 0) continue;

                for(int i= curBox.from; i<curBox.to; i++){
                    remain[i] -= take;
                }
                count+=take;

            }


            System.out.println(count);









        }

    }