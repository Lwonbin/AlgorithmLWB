    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class guitar{
            int packagE;
            int notgae;

            guitar(int packagE, int notgae){
                this.notgae = notgae;
                this.packagE = packagE;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            List<guitar> guitars = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int curPac = Integer.parseInt(st.nextToken());
                int curNot = Integer.parseInt(st.nextToken());
                guitars.add(new guitar(curPac, curNot));
            }

            Collections.sort(guitars, (o1,o2) ->{
                return o1.packagE - o2.packagE;
            });

            int sum = 0;
            int cnt = N / 6;

            sum += guitars.get(0).packagE * cnt;

            int PackSum = guitars.get(0).packagE * (cnt+1);

            Collections.sort(guitars, (o1,o2) ->{
                return o1.notgae - o2.notgae;
            });
            int NotSum = guitars.get(0).notgae * N;


            cnt = N % 6;
            sum += guitars.get(0).notgae * cnt;


            sum = Math.min(Math.min(PackSum, NotSum), sum);


            System.out.println(sum);








        }

    }