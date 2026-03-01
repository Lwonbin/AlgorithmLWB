    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static class Date{
            int start;
            int end;

            Date(int start, int end){
                this.start = start;
                this.end = end;
            }
        }
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            List<Date> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String StartMon = st.nextToken();
                String StartDay = st.nextToken();
                String EndMon = st.nextToken();
                String EndDay = st.nextToken();

                if(StartDay.length() == 1){
                    StartDay = '0'+StartDay;
                }
                if(EndDay.length() == 1){
                    EndDay = '0'+EndDay;
                }

                int start = Integer.parseInt(StartMon + StartDay);
                int end = Integer.parseInt(EndMon + EndDay);
                Date curDate = new Date(start, end);
                list.add(curDate);
            }

            Collections.sort(list, (o1, o2) ->{
                if(o1.start==o2.start){
                    return Integer.compare(o2.end, o1.end);
                }
                return Integer.compare(o1.start, o2.start);
            });



            int curEnd = 301;
            int endTarget = 1201;

            int count = 0;

            int idx = 0;

            while(true){
                int maxEnd = curEnd;

                while(idx<N && list.get(idx).start <= curEnd){
                    maxEnd = Math.max(maxEnd, list.get(idx).end);
                    idx++;
                }
                if(maxEnd >=endTarget){
                    count++;
                    break;
                }

                if(maxEnd == curEnd){
                    System.out.println(0);
                    return;
                }

                curEnd = maxEnd;
                count++;

            }


            System.out.println(count);






        }

    }