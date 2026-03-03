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



            int N = Integer.parseInt(br.readLine());

            List<flower> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                String sm = st.nextToken();
                String sd = st.nextToken();
                String em = st.nextToken();
                String ed = st.nextToken();

                if(sd.length() == 1){
                    sd = '0'+sd;
                }
                if(ed.length() == 1){
                    ed = '0'+ed;
                }

                int start = Integer.parseInt(sm+sd);
                int end = Integer.parseInt(em+ed);
                list.add(new flower(start, end));
            }

            Collections.sort(list, (o1, o2) ->{
                if(o1.start == o2.start){
                    return Integer.compare(o2.end, o1.end);
                }
                return Integer.compare(o1.start, o2.start);
            });


            int cur = 301;
            int target = 1201;

            int idx = 0;
            int count = 0;
            while(cur < target){

                int maxEnd = cur;


                while(idx < N && list.get(idx).start <= cur){
                    maxEnd = Math.max(maxEnd, list.get(idx).end);
                    idx++;
                }


                if(maxEnd == cur){
                    System.out.println(0);
                    return;
                }

                cur = maxEnd;
                count++;
            }


            System.out.println(count);







        }

    }