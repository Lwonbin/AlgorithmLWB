    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class flower{
            int start;
            int end;

            flower(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int answer = 0;

            int N = Integer.parseInt(br.readLine());

            List<flower> garden = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String curSM = st.nextToken();
                String curSD = st.nextToken();
                String curEM = st.nextToken();
                String curED = st.nextToken();

                if(curSD.length() == 1){
                    curSD = "0"+curSD;
                }
                if(curED.length() == 1){
                    curED = "0"+curED;
                }

                int curS = Integer.parseInt(curSM+curSD);
                int curE = Integer.parseInt(curEM+curED);

                flower curFlower = new flower(curS, curE);
                garden.add(curFlower);
            }

            Collections.sort(garden, (o1,o2) -> {
                if(o1.start == o2.start){
                    return o2.end - o1.end;
                }
                return o1.start - o2.start;
            });

            int count = 0;

            int cur = 301;
            int idx = 0;

            while(cur < 1201){
                int maxEnd = cur;

                while(idx < N && garden.get(idx).start <= cur){
                    maxEnd = Math.max(maxEnd, garden.get(idx).end);
                    idx++;
                }

                if(maxEnd == cur){
                    System.out.println(0);
                    return;
                }

                count++;
                cur = maxEnd;
            }

            System.out.println(count);




        }

    }